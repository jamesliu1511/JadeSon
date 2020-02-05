package com.jade.path.exception;

public class ItemMissingException extends RuntimeException{
	private static final long serialVersionUID = 1L;

    public ItemMissingException(String message) {
        super(message);
    }
}
