package refactored;

import refactored.Config.DBProperties;
import refactored.exception.DAOConfigException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The class implements Factory pattern
 */
public abstract class DAOFactory {

    private static final String HOSTNAME = "hostname";
    private static final String PORT = "port";
    private static final String PROPERTY_URL = "database";
    private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD = "password";


    /**
     * Returns a new DAOFactory instance. Could be extended for DataSource.
     *
     * @param name The switcher between JNDI and... could be
     * @return A new DAOFactory instance for .
     * @throws DAOConfigException In case database name is null, or ...
     */

    public static DAOFactory getInstance(String name) throws DAOConfigException {


        DBProperties properties = new DBProperties();
        String hostname = properties.getProperty(HOSTNAME);
        String port = properties.getProperty(PORT);
        String database = properties.getProperty(PROPERTY_URL);
        String password = properties.getProperty(PROPERTY_PASSWORD);
        String username = properties.getProperty(PROPERTY_USERNAME);
        if (!isConsistentProperties(hostname, port, database, username, password)) {
            throw new DAOConfigException("Incorrect DB properties!");
        }
        return new UrlManagedDAOFactory(hostname, port, database, username, password);
    }


    /**
     * Returns a connection to the database.
     *
     * @return A connection to the database.
     * @throws SQLException If acquiring the connection fails.
     */
    abstract Connection getConnection() throws SQLException;

    /**
     * Returns the User DAO associated with the current DAOFactory.
     *
     * @return The User DAO associated with the current DAOFactory.
     */
    public AdressDAO getUserDAO() {
        return new AdressDAOImpl(this);
    }


    /**
     * checks properties.
     *
     * @return True if properties are correct.
     */
    private static boolean isConsistentProperties(String hostname, String port, String database, String username, String password) {
        // check ...
        return true;
    }
}
