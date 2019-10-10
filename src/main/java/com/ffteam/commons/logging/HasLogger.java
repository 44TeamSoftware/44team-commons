package com.ffteam.commons.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This interface allow us easy to add logger to any class
 */
public interface HasLogger {
	
	/**
	 * Return {@link Logger} for current class
	 * 
	 * @return {@link Logger} for current class
	 */
	default Logger getLogger() {
		return LoggerFactory.getLogger(getClass());
	}
}
