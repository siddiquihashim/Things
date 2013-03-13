package com.spr.hib.exceptions;

public class EmailAlreadyExistException extends RuntimeException {//TODO need hiearchery and maybe spring runtime exceptions

	public EmailAlreadyExistException(String email) {
		super(email);
	}

}
