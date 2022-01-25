/**
 * 
 */
package com.bestgamesreviews.exception;

/**
 * @author Rudolph
 *Classe qui gére les exceptions des objet classification
 */
@SuppressWarnings("serial")
public class ClassificationException extends Exception {

	/**
	 * 
	 */
	public ClassificationException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ClassificationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ClassificationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ClassificationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ClassificationException(Throwable cause) {
		super(cause);
	}

}
