/**
 * 
 */
package com.bestgamesreviews.exception;

/**
 * @author Administrator
 *Classe qui gére les exceptions des objets Utilisateur
 */
@SuppressWarnings("serial")
public class UtilisateurException extends Exception {

	/**
	 * 
	 */
	public UtilisateurException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UtilisateurException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UtilisateurException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UtilisateurException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UtilisateurException(Throwable cause) {
		super(cause);
	}

}
