package ui_tests.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnvironmentPropertyLoader {
	private static EnvironmentPropertyLoader instance = null;
	private String environmentConfig;
	private Properties property = null;
	private static Logger log = LoggerFactory.getLogger(EnvironmentPropertyLoader.class);

	private EnvironmentPropertyLoader() {
		property = new Properties();
		environmentConfig = System.getProperty("environment.config");
		String propertiesPath = "./src/test/resources/envs/" + environmentConfig;
		FileInputStream fis;
		try {
			fis = new FileInputStream(propertiesPath);
			property.load(fis);
		} catch (IOException e) {
			log.error("ERROR: Property file missing!");
		}
	}

	public static EnvironmentPropertyLoader getInstance() {
		if (instance == null) {
			instance = new EnvironmentPropertyLoader();
		}
		return instance;
	}

	public String getProperty(String key) {
		String value = null;
		if (property.containsKey(key)) {
			value = property.getProperty(key);
		} else {
			log.error("ERROR: Property \"" + key + "\" not found!");
		}
		return value;
	}
}
