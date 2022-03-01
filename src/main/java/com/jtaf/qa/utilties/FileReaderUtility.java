package com.jtaf.qa.utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @implNote This class contains the File Reader utility used to read the data
 *           from the property files.
 * @author Jaga
 * @since 14-02-2022
 * @version v0.1
 *
 */
public class FileReaderUtility {

	private static Properties properties;
	private static File file;
	private static FileInputStream fileInputStream;

	private static String propertyFilePath = "//src//main//resources//configurations//";
	private static String testConfigFile = "TestConfig.properties";

	// Logger log = getLogger(FileReaderUtility.class);

	public void loadPropertyFile() throws IOException {
		try {
			properties = new Properties();
			file = new File(System.getProperty("user.dir") + propertyFilePath + testConfigFile);
			try {
				fileInputStream = new FileInputStream(file);
			} catch (FileNotFoundException ex) {
				System.out.println("======================== [ Property file " + testConfigFile
						+ " not found ] ========================");
				ex.printStackTrace();
			}
			try {
				properties.load(fileInputStream);
			} catch (IOException ex) {
				ex.printStackTrace();
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
			ex.printStackTrace();
		}
		return dataFromPropFile;
	}

}