package com.jtaf.qa.utilties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @implNote This class contains the Logger utility used to maintain the
 *           execution logs.
 * 
 * @author Jaga
 * @since 08-03-2022
 * @version v0.2
 *
 */
public class LoggerUtility {

	private static boolean root = false;

	private static String propertyFilePath = "//src//main//resources//configurations//";
	private static String logConfigFile = "log4j.properties";

	public Logger getLogger(Class<?> cls) {
		if (root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(System.getProperty("user.dir") + propertyFilePath + logConfigFile);
		root = true;
		return Logger.getLogger(cls);
	}

}
