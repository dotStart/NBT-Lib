package com.evilco.mc.nbt;

import com.evilco.mc.nbt.stream.NBTInputStream;
import com.evilco.mc.nbt.stream.NBTOutputStream;

import javax.annotation.Nonnull;
import java.io.IOException;

/**
 * @auhtor Johannes Donath <johannesd@evil-co.com>
 * @copyright Copyright (C) 2014 Evil-Co <http://www.evil-co.org>
 */
public class TagInteger extends AbstractTag {

	/**
	 * Stores the tag value.
	 */
	protected int value;

	/**
	 * Constructs a new TagInteger.
	 * @param name
	 * @param value
	 */
	public TagInteger (@Nonnull String name, int value) {
		super (name);
		this.setValue (value);
	}

	/**
	 * Constructs a new TagInteger.
	 * @param inputStream
	 * @param anonymous
	 * @throws IOException
	 */
	public TagInteger (@Nonnull NBTInputStream inputStream, boolean anonymous) throws IOException {
		super (inputStream, anonymous);

		this.setValue (inputStream.readInt ());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte getTagID () {
		return TagType.INTEGER.typeID;
	}

	/**
	 * Returns the tag value.
	 * @return
	 */
	public int getValue () {
		return this.value;
	}

	/**
	 * Sets a new tag value.
	 * @param i
	 */
	public void setValue (int i) {
		this.value = i;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write (NBTOutputStream outputStream, boolean anonymous) throws IOException {
		super.write (outputStream, anonymous);

		// write value
		outputStream.writeInt (this.value);
	}
}