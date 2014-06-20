package com.evilco.mc.nbt.tag;

import java.io.IOException;

/**
 * An exception that is thrown when an entry of a TagCompound or TagList
 * is not of the expected tag type
 */
public class UnexpectedTagTypeException extends IOException {
	public UnexpectedTagTypeException() {
	}

	public UnexpectedTagTypeException(String message) {
		super(message);
	}

	public UnexpectedTagTypeException(Throwable cause) {
		super(cause);
	}

	public UnexpectedTagTypeException(String message, Throwable cause) {
		super(message, cause);
	}
}
