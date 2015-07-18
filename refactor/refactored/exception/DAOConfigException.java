package refactored.exception;

/**
 * This class used for Exceptions  with DB file configuration
 */
public class DAOConfigException extends RuntimeException {

     private static final long serialVersionUID = 1L;

     /**
     * Constructs a .
     * @param message .
     */
    public DAOConfigException(String message) {
        super(message);
    }

    /**
     * Constructs a .
     * @param cause The root cause of the DAOConfigurationException.
     */
    public DAOConfigException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs
     * @param message .
     * @param cause .
     */
    public DAOConfigException(String message, Throwable cause) {
        super(message, cause);
    }

}
