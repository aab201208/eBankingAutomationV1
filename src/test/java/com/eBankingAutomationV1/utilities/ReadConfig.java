package com.eBankingAutomationV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream stream;
			stream = new FileInputStream(src);
			prop = new Properties();
			prop.load(stream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}

	public String getUsername() {
		String username = prop.getProperty("userName");
		return username;
	}

	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}

	public String getChromePath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}

	public String getEdgePath() {
		String edgepath = prop.getProperty("edgepath");
		return edgepath;
	}
}
