package by.tc.carrental.model.dao.connection;

import by.tc.carrental.model.dao.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DBConnectionPool {
    private String driver;
    private String url;
    private String user;
    private String password;
    private int poolSize;

    private BlockingQueue<Connection> connectionQueue;
    private BlockingQueue<Connection> usedConnections;

    private static DBConnectionPool instance = null;

    static {
        try {
            instance = new DBConnectionPool();
        }
        catch(DAOException ex) {
            ex.printStackTrace();
        }
    }

    private DBConnectionPool() throws DAOException {
        DBResourceManager dbResourceManager = DBResourceManager.getInstance();
        this.driver = dbResourceManager.getValue(DBParameter.DB_DRIVER);
        this.url = dbResourceManager.getValue(DBParameter.DB_URL);
        this.user = dbResourceManager.getValue(DBParameter.DB_USER);
        this.password = dbResourceManager.getValue(DBParameter.DB_PASSWORD);
        this.poolSize = Integer.parseInt(dbResourceManager.getValue(DBParameter.DB_POOL_SIZE));

        init();
    }

    private void init() throws DAOException {
        try {
            Class.forName(driver);
            connectionQueue = new ArrayBlockingQueue<Connection>(poolSize);
            usedConnections = new ArrayBlockingQueue<Connection>(poolSize);

            for(int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                connectionQueue.add(connection);
            }
        }
        catch(ClassNotFoundException | SQLException e) {
            throw new DAOException("Connection error: " + e.getMessage());
        }
    }

    public static DBConnectionPool getInstance() {
        return instance;
    }

    public Connection getConnection() throws DAOException {
        Connection connection = null;

        try {
            connection = connectionQueue.take();
            usedConnections.add(connection);
        }
        catch (InterruptedException e) {
            throw new DAOException("Connection error: " + e.getMessage());
        }
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        if(connection != null) {
            usedConnections.remove(connection);
            return connectionQueue.add(connection);
        }

        return false;
    }
}