/**
 * 
 */
package com.bestgamesreviews.exception;

/**
 * @author rudolph
 *Classe qui gére les exceptions des objet Genre
 */
@SuppressWarnings("serial")
public class GenreException extends Exception {

	/**
	 * 
	 */
	public GenreException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public GenreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public GenreException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public GenreException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public GenreException(Throwable cause) {
		super(cause);
	}

	
}
