package com.evilco.mc.nbt.tag;

import com.evilco.mc.nbt.stream.NBTInputStream;
import com.evilco.mc.nbt.stream.NBTOutputStream;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @auhtor Johannes Donath <johannesd@evil-co.com>
 * @copyright Copyright (C) 2014 Evil-Co <http://www.evil-co.org>
 */
public class TagCompound extends AbstractTag implements INamedTagContainer {

	/**
	 * Stores all child tags.
	 */
	protected Map<String, ITag> tags;

	/**
	 * Constructs a new TagCompound.
	 * @param name The tag name.
	 */
	public TagCompound (String name) {
		super (name);

		this.tags = new HashMap<> ();
	}

	/**
	 * Constructs a new TagCompound.
	 * @param inputStream
	 * @param anonymous
	 */
	public TagCompound (@Nonnull NBTInputStream inputStream, boolean anonymous) throws IOException {
		super (inputStream, anonymous);

		// create map
		this.tags = new HashMap<> ();

		// attempt to read all elements
		do {
			// read type
			byte type = inputStream.readByte ();

			// get type
			TagType tagType = TagType.valueOf (type);

			// error!
			if (tagType == null) throw new IOException ("Could not find a tag for type ID " + type + ".");

			// reached end
			if (tagType == TagType.END) break;

			// read tag
			this.setTag (inputStream.readTag (tagType, false));
		} while (true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITag getTag (@Nonnull String name) {
		// check arguments
		Preconditions.checkNotNull (name, "name");

		// return tag
		return this.tags.get (name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, ITag> getTags () {
		return (new ImmutableMap.Builder<String, ITag> ().putAll (this.tags)).build ();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeTag (@Nonnull ITag tag) {
		// check arguments
		Preconditions.checkNotNull (tag, "tag");

		// delete tag
		this.tags.remove (tag.getName ());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeTag (@Nonnull String tag) {
		// check arguments
		Preconditions.checkNotNull (tag, "tag");

		// delete tag
		this.tags.remove (tag);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTag (@Nonnull ITag tag) {
		// check arguments
		Preconditions.checkNotNull (tag, "tag");

		// delete previous
		if (this.tags.containsKey (tag)) this.tags.get (tag.getName ()).setParent (null);

		// store tag
		this.tags.put (tag.getName (), tag);

		// update parent
		tag.setParent (this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte getTagID () {
		return TagType.COMPOUND.typeID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write (NBTOutputStream outputStream, boolean anonymous) throws IOException {
		super.write (outputStream, anonymous);

		// write tags
		for (Map.Entry<String, ITag> tagEntry : this.tags.entrySet ()) {
			// write tag ID
			outputStream.writeByte (tagEntry.getValue ().getTagID ());

			// write tag
			tagEntry.getValue ().write (outputStream, false);
		}

		// write end tag
		outputStream.writeByte (TagType.END.typeID);
	}
}