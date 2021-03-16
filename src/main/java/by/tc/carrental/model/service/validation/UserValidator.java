package by.tc.carrental.model.service.validation;

import by.tc.carrental.model.entity.User;
import by.tc.carrental.model.service.ServiceException;

public interface UserValidator {
    public boolean checkAuthData(User user) throws ServiceException;
    public boolean checkRegData(User user) throws ServiceException;
}
