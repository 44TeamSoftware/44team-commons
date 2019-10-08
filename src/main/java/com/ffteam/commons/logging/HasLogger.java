package com.ffteam.commons.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface HasLogger {
	
	default Logger getLogger() {
		return LoggerFactory.getLogger(getClass());
	}
}
