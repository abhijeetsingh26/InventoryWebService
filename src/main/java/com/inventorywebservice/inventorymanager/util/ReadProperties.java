package com.inventorywebservice.inventorymanager.util;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	private static ReadProperties instance;

	static {
		instance = new ReadProperties();
	}

	private ReadProperties() {
	}

	public static synchronized ReadProperties getInstance() {
		if (instance == null) {
			instance = new ReadProperties();
		}
		return instance;
	}

	public Properties readConfigProperties() {

		Properties prop = new Properties();
		try {
			prop.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
			// System.out.println(prop.getProperty("dbpassword"));
			return prop;

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}

}
