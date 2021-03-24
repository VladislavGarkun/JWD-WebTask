package by.tc.carrental.model.dao.connection;

public class DBConnectionException extends Exception{
    private static final long serialVersionUID = -744983591406056354L;

    public DBConnectionException() {
        super();
    }

    public DBConnectionException(String message) {
        super(message);
    }

    public DBConnectionException(Exception e) {
        super(e);
    }

    public DBConnectionException(String message, Exception e) {
        super(message, e);
    }
}