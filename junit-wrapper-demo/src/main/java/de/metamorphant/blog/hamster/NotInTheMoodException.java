package de.metamorphant.blog.hamster;

public class NotInTheMoodException extends RuntimeException {
	public NotInTheMoodException(String reason) {
		super(reason);
	}
}
