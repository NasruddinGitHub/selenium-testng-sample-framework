package com.citibank.automation.helpers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

	private static ConfigManager instance;

	private static Properties properties;

	private static final String PROPERTY_FILE_PATH = "C:\\Users\\Headway\\eclipse-workspace\\automate-citibank\\src\\test\\resources\\test.properties";
	
	private ConfigManager() throws IOException {
		loadProperties();
	}
	
	public static ConfigManager getInstance() {
		if (instance == null) {
			try {
				instance = new ConfigManager();
			} catch (IOException e) {
				System.out.println("IOException is thrown while reading the properties");
			}
		}
		return instance;
	}

	private void loadProperties() throws IOException {
		properties = new Properties();
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(new File(PROPERTY_FILE_PATH));
			properties.load(fileReader);
		} catch (IOException e) {
			System.out.println("Error has been thrown while reading property file");
		} finally {
			fileReader.close();
		}
	}
	
	public String getProperty(String property) {
		return properties.getProperty(property);
	}
}
