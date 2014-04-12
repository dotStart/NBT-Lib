package com.evilco.mc.nbt;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @auhtor Johannes Donath <johannesd@evil-co.com>
 * @copyright Copyright (C) 2014 Evil-Co <http://www.evil-co.org>
 */
public interface IAnonymousTagContainer extends ITagContainer {

	/**
	 * Adds a new tag.
	 * @param tag
	 */
	public void addTag (@Nonnull ITag tag);

	/**
	 * Returns a list of all tags.
	 * @return
	 */
	public List<ITag> getTags ();

	/**
	 * Sets a tag.
	 * @param i
	 * @param tag
	 */
	public void setTag (int i, @Nonnull ITag tag);
}