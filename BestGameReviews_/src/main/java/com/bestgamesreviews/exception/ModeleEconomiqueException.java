/**
 * 
 */
package com.bestgamesreviews.exception;

/**
 * @author Rudolplh
 *classe qui gére les exception des objets ModeleEconomique
 */
@SuppressWarnings("serial")
public class ModeleEconomiqueException extends Exception {

	/**
	 * 
	 */
	public ModeleEconomiqueException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ModeleEconomiqueException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ModeleEconomiqueException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ModeleEconomiqueException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ModeleEconomiqueException(Throwable cause) {
		super(cause);
	}

}
