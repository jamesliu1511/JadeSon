package com.jade.path.exception;

public class TemplateWrong extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public TemplateWrong(String message){
		super(message);
	}
}
