package liashenko.airline.service.exceptions;

public class ServiceException extends RuntimeException {
    public ServiceException() {
    }

    public ServiceException(String s) {
        super(s);
    }
}
