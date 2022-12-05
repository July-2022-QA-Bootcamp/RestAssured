package utils;

import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	private Properties properties;
	
	public ReadConfig() {
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("environment.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String get(String key) {
		return properties.getProperty(key);
	}
}
