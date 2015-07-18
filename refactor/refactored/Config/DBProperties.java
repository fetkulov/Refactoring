package refactored.Config;

import refactored.exception.DAOConfigException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * DBProperties class immediately loads the properties file 'db.properties' in memory.
 */
public final class DBProperties {

    private static final String PROPERTIES_FILE_NAME = "db.properties";
    private static final Properties PROPERTIES = new Properties();

    static {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = loader.getResourceAsStream(PROPERTIES_FILE_NAME);

        if (propertiesFile == null) {
            throw new DAOConfigException(
                    "Properties file - '" + PROPERTIES_FILE_NAME + "' is missing in classpath.");
        }
        try {
            PROPERTIES.load(propertiesFile);
        } catch (IOException e) {
            throw new DAOConfigException(
                    "Cannot load properties file '" + PROPERTIES_FILE_NAME + "'.", e);
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

}