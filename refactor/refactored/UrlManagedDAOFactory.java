package refactored;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by михайло on 08.02.15.
 */
public class UrlManagedDAOFactory extends DAOFactory {

    /**
     * Returns a connection to the database. Package private so that it can be used inside the package
     *
     * @return A connection to the database.
     * @throws SQLException If acquiring the connection fails.
     */
    private String hostname;
    private String port;
    private String database;
    private String username;
    private String password;


    public UrlManagedDAOFactory(String hostname, String port, String database, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    Connection getConnection() throws SQLException {
        Connection conn = null;
        String jdbcUrl = "jdbc:oracle:thin:@" + this.hostname + ":" + this.port + ":" + this.database;
        conn = DriverManager.getConnection(jdbcUrl, username, password);
        return conn;
    }

}
