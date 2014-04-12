package com.evilco.mc.nbt.tag;

import com.evilco.mc.nbt.stream.NbtInputStream;
import com.evilco.mc.nbt.stream.NbtOutputStream;
import com.google.common.base.Preconditions;

import javax.annotation.Nonnull;
import java.io.IOException;

/**
 * @auhtor Johannes Donath <johannesd@evil-co.com>
 * @copyright Copyright (C) 2014 Evil-Co <http://www.evil-co.org>
 */
public class TagByteArray extends AbstractTag {

	/**
	 * Stores the tag value.
	 */
	protected byte[] value;

	/**
	 * Constructs a new TagByteArray.
	 * @param name
	 * @param value
	 */
	public TagByteArray (@Nonnull String name, @Nonnull byte[] value) {
		super (name);
		this.setValue (value);
	}

	/**
	 * Constructs a new TagByteArray.
	 * @param inputStream
	 * @param anonymous
	 * @throws IOException
	 */
	public TagByteArray (@Nonnull NbtInputStream inputStream, boolean anonymous) throws IOException {
		super (inputStream, anonymous);

		// read size
		int size = inputStream.readInt ();

		// read data
		byte[] data = new byte[size];
		inputStream.readFully (data);

		// store data
		this.setValue (data);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte getTagID () {
		return TagType.BYTE_ARRAY.typeID;
	}

	/**
	 * Returns the tag value.
	 * @return
	 */
	public byte[] getValue () {
		return this.value;
	}

	/**
	 * Sets a new tag value.
	 * @param b
	 */
	public void setValue (@Nonnull byte[] b) {
		// check arguments
		Preconditions.checkNotNull (b, "b");

		// save value
		this.value = b;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write (NbtOutputStream outputStream, boolean anonymous) throws IOException {
		super.write (outputStream, anonymous);

		// write size
		outputStream.writeInt (this.value.length);

		// write data
		outputStream.write (this.value);
	}
}