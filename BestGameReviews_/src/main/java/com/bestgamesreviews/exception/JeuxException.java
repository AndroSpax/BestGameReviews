/**
 * 
 */
package com.bestgamesreviews.exception;

/**
 * @author Rudolph
 *Classe qui gére les exceptions des objet jeux
 */
@SuppressWarnings("serial")
public class JeuxException extends Exception {

	/**
	 * Empty construtor
	 */
	public JeuxException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public JeuxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public JeuxException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public JeuxException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public JeuxException(Throwable cause) {
		super(cause);
	}

}
