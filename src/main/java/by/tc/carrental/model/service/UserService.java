package by.tc.carrental.model.service;

import by.tc.carrental.model.entity.User;

import javax.servlet.ServletException;

public interface UserService {
    public boolean registration(User user) throws ServiceException;
    public User authorization(User user) throws ServiceException;
}
