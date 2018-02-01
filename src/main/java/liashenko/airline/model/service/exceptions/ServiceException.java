package liashenko.airline.model.service.exceptions;

public class ServiceException extends RuntimeException {
    public ServiceException() {
    }

    public ServiceException(String s) {
        super(s);
    }
}
