package com.evilco.mc.nbt;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * @auhtor Johannes Donath <johannesd@evil-co.com>
 * @copyright Copyright (C) 2014 Evil-Co <http://www.evil-co.org>
 */
public interface INamedTagContainer extends ITagContainer {

	/**
	 * Returns the tag associated with the given name.
	 * @param name The tag name.
	 */
	public ITag getTag (@Nonnull String name);

	/**
	 * Returns a named map of all tags.
	 * @return
	 */
	public Map<String, ITag> getTags ();

	/**
	 * Removes a tag from the container.
	 * @param tag The tag name.
	 */
	public void removeTag (@Nonnull String tag);

	/**
	 * Sets a new tag.
	 * @param tag The tag.
	 */
	public void setTag (@Nonnull ITag tag);
}