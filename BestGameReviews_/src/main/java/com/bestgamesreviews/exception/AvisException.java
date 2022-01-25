/**
 * 
 */
package com.bestgamesreviews.exception;

/**
 * @author Rudolph
 *
 */
public class AvisException extends Exception {

	/**
	 * classe qui gére lesq exception de l'objet Avis
	 */
	public AvisException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AvisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AvisException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public AvisException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AvisException(Throwable cause) {
		super(cause);
	}

}
