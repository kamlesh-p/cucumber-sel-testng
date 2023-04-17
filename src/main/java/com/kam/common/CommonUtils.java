package com.kam.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import lombok.extern.log4j.Log4j2;

/**
 * @author kamlesh
 *
 */
@Log4j2
public final class CommonUtils {

	private CommonUtils() {
		// No Init
	}

	/**
	 * read property files from given path.
	 *
	 * @param filePath
	 * @return Properties
	 */
	public static Properties readProperties(final String filePath) {
		Properties properties = new Properties();
		log.info("Read properties from {}", filePath);
		try (FileInputStream fis = new FileInputStream(filePath)) {
			properties.load(fis);
			return properties;
		} catch (IOException e) {
			log.error("IOException while loading properties file: {0}", e);
		}
		return properties;
	}
}
