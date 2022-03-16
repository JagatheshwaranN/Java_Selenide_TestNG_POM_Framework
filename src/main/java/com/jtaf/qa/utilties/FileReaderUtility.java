package com.jtaf.qa.utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * 
 * @implNote This class contains the File Reader utility used to read the data
 *           from the property files.
 *           
 * @author Jaga
 * @since 09-03-2022
 * @version v0.3
 *
 */
public class FileReaderUtility extends LoggerUtility {

	Logger log = getLogger(FileReaderUtility.class);

	private static Properties properties;
	private static File file;
	private static FileInputStream fileInputStream;

	private static String propertyFilePath = "//src//main//resources//configurations//";
	private static String testConfigFile = "TestConfig.properties";

	public void loadPropertyFile() throws IOException {
		try {
			properties = new Properties();
			file = new File(System.getProperty("user.dir") + propertyFilePath + testConfigFile);
			try {
				fileInputStream = new FileInputStream(file);
			} catch (FileNotFoundException ex) {
				log.info("======================== [ Property file " + testConfigFile
						+ " not found ] ========================" + "\n" + ex);
			}
			try {
				properties.load(fileInputStream);
			} catch (IOException ex) {
				log.info("Error occured while property file load");
			}
		} finally {
			fileInputStream.close();
		}
	}

	public String getTestData(String property) {
		String dataFromPropFile = null;
		try {
			dataFromPropFile = properties.getProperty(property).trim();
		} catch (Exception ex) {
			log.info("Error occured while get the data from the property file" + "\n" + ex);
		}
		return dataFromPropFile;
	}

}