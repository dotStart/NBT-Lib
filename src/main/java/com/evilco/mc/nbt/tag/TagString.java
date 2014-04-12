package com.evilco.mc.nbt.tag;

import com.evilco.mc.nbt.stream.NBTInputStream;
import com.evilco.mc.nbt.stream.NBTOutputStream;

import javax.annotation.Nonnull;
import java.io.IOException;

/**
 * @auhtor Johannes Donath <johannesd@evil-co.com>
 * @copyright Copyright (C) 2014 Evil-Co <http://www.evil-co.org>
 */
public class TagString extends AbstractTag {

	/**
	 * Stores the tag value.
	 */
	protected String value;

	/**
	 * Constructs a new TagString.
	 * @param name
	 * @param value
	 */
	public TagString (@Nonnull String name, @Nonnull String value) {
		super (name);
		this.setValue (value);
	}

	/**
	 * Constructs a new TagString.
	 * @param inputStream
	 * @param anonymous
	 * @throws IOException
	 */
	public TagString (@Nonnull NBTInputStream inputStream, boolean anonymous) throws IOException {
		super (inputStream, anonymous);

		// read size
		int size = inputStream.readShort ();

		// read bytes
		byte[] data = new byte[size];
		inputStream.readFully (data);

		// store value
		this.setValue (new String (data, ITag.STRING_CHARSET));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte getTagID () {
		return TagType.STRING.typeID;
	}

	/**
	 * Returns the tag value.
	 * @return
	 */
	public String getValue () {
		return this.value;
	}

	/**
	 * Sets a new tag value.
	 * @param s
	 */
	public void setValue (@Nonnull String s) {
		this.value = s;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write (NBTOutputStream outputStream, boolean anonymous) throws IOException {
		super.write (outputStream, anonymous);

		// write length
		outputStream.writeShort (this.value.length ());

		// write string
		outputStream.write (this.value.getBytes (ITag.STRING_CHARSET));
	}
}