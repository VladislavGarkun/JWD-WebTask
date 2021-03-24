package by.tc.carrental.model.dao.impl;

import by.tc.carrental.model.dao.DAOException;
import by.tc.carrental.model.dao.UserDAO;
import by.tc.carrental.model.dao.connection.DBConnectionException;
import by.tc.carrental.model.dao.connection.DBConnectionPool;
import by.tc.carrental.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {
    private static final String ADD_NEW_USER = "INSERT INTO carrental.users (login, password, name, surname, userName, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SEARCH_USER = "SELECT * FROM carrental.users WHERE login = ? AND password = ?";
    private static final String UPDATE_PROFILE_DESC = "UPDATE carrental.users SET login = ?, password = ?, name = ?, surname = ?, phoneNumber = ? WHERE userName = ?";
    //private static int role_client = 1; //to do - load from db
    //private static int role_ph = 2;

    private static final String ERROR_WHILE_UPD_MESSAGE = "Sorry! Server error occured, your changes are not saved!";

    private final DBConnectionPool connectionPool = DBConnectionPool.getInstance();

    @Override
    public boolean registration(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();

            preparedStatement = connection.prepareStatement(ADD_NEW_USER);

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getSurname());
            preparedStatement.setString(5, user.getUserName());
            preparedStatement.setString(6, user.getPhoneNumber());

            try {
                preparedStatement.executeUpdate();
            }
            catch(SQLException ex) {
                throw new DAOException("User with this username already existst!");
            }

        }
        catch(SQLException e) {
            throw new DAOException("Connection error: " + e.getMessage());
        }
        finally {
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {

                try {
                    connection.close();
                    connectionPool.closeConnection(connection);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }

    @Override
    public User authorization(User user) throws DAOException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User authorizedUser = null;

        try
        {
            connection = connectionPool.getConnection();

            preparedStatement = connection.prepareStatement(SEARCH_USER);

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                authorizedUser = new User(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7));
            }
        }
        catch(SQLException e) {
            throw new DAOException("Connection error: " + e.getMessage());
        }
        finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null) {
                try {
                    connection.close();
                    connectionPool.closeConnection(connection);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return authorizedUser;
    }

    @Override
    public boolean updateProfile(User user, String userName) throws DAOException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = connectionPool.getConnection();

        try {
            preparedStatement = connection.prepareStatement(UPDATE_PROFILE_DESC);

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getSurname());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setString(6, userName);


            if(preparedStatement.executeUpdate() < 1) {
                throw new DAOException(ERROR_WHILE_UPD_MESSAGE);
            }
        }
        catch(SQLException e) {
            //log.error(e.getMessage());
            throw new DAOException(ERROR_WHILE_UPD_MESSAGE, e);
        }
        finally {
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                }
                catch (SQLException e) {
                    //log.error(ERROR_WHILE_CLOSING_STATEMENT + e.getMessage());
                }
            }

            if(connection != null) {
                connectionPool.closeConnection(connection);
            }
        }
        return true;
    }
}
