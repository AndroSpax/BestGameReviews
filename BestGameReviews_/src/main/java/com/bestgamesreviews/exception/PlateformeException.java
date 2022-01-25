/**
 * 
 */
package com.bestgamesreviews.exception;

/**
 * @author Administrator
 *classe qui gére les exception des objets PlateformeException
 */
@SuppressWarnings("serial")
public class PlateformeException extends Exception {

	/**
	 * 
	 */
	public PlateformeException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PlateformeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PlateformeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public PlateformeException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PlateformeException(Throwable cause) {
		super(cause);
	}

}
