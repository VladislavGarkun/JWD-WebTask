package by.tc.carrental.model.dao;

import by.tc.carrental.model.entity.User;

public interface UserDAO {
    public boolean registration(User user) throws DAOException;
    public User authorization(User user) throws DAOException;
}
