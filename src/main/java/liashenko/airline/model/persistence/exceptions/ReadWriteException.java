package liashenko.airline.model.persistence.exceptions;


public class ReadWriteException extends PersistenceException {

    public ReadWriteException() {
    }

    public ReadWriteException(String message) {
        super(message);
    }
}
