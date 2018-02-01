package liashenko.airline.persistence.exceptions;


public class ReadWriteException extends PersistenceException {

    public ReadWriteException() {
    }

    public ReadWriteException(String message) {
        super(message);
    }
}
