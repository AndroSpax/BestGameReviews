/**
 * 
 */
package com.bestgamesreviews.exception;

/**
 * @author Rudolph
 *Classe qui gére les exception des objets Editeur
 */
@SuppressWarnings("serial")
public class EditeurException extends Exception {

	/**
	 * 
	 */
	public EditeurException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public EditeurException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EditeurException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public EditeurException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public EditeurException(Throwable cause) {
		super(cause);
	}

}
