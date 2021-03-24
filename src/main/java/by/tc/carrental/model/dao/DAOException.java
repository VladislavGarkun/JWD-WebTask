package by.tc.carrental.model.dao;

public class DAOException extends Exception{
    private static final long serialVersionUID = -5026629693456812271L;

    public DAOException(){
        super();
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(Exception ex){
        super(ex);
    }

    public DAOException(String message, Exception ex){
        super(message, ex);
    }
}
