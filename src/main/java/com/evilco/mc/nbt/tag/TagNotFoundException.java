package com.evilco.mc.nbt.tag;

import java.io.IOException;

/**
 * An exception that is thrown when trying to access a component of a CompoundTag that does not exist
 */
public class TagNotFoundException extends IOException {
	public TagNotFoundException() {
	}

	public TagNotFoundException(String message) {
		super(message);
	}

	public TagNotFoundException(Throwable cause) {
		super(cause);
	}

	public TagNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
