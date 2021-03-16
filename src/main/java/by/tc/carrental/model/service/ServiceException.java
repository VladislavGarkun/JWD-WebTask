package by.tc.carrental.model.service;

public class ServiceException extends Exception{
    private static final long serialVersionUID = -3549843709850795399L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception ex) {
        super(ex);
    }

    public ServiceException(String message, Exception ex) {
        super(message, ex);
    }
}
