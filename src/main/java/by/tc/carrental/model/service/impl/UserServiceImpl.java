package by.tc.carrental.model.service.impl;

import by.tc.carrental.model.dao.DAOException;
import by.tc.carrental.model.dao.DAOProvider;
import by.tc.carrental.model.dao.UserDAO;
import by.tc.carrental.model.entity.User;
import by.tc.carrental.model.service.ServiceException;
import by.tc.carrental.model.service.UserService;
import by.tc.carrental.model.service.validation.UserValidator;
import by.tc.carrental.model.service.validation.ValidatorProvider;

public class UserServiceImpl implements UserService {
    private static final String NO_UPDATE_ERROR = "Server error! Changes are not saved";

    @Override
    public boolean registration(User user) throws ServiceException {
        ValidatorProvider validatorProvider = ValidatorProvider.getInstance();
        UserValidator userValidator = validatorProvider.getUserValidator();

        DAOProvider daoProvider = DAOProvider.getInstance();
        UserDAO userDAO = daoProvider.getUserDAO();

        try {
            if(userValidator.checkRegData(user)) {
                try {
                    boolean successfulRegistration = userDAO.registration(user);
                    return successfulRegistration;
                }
                catch(DAOException e) {
                    throw new ServiceException("Error while registration: " + e.getMessage());
                }
            }
        }
        catch(ServiceException e) {
            throw new ServiceException(e);
        }

        return false;
    }

    @Override
    public User authorization(User user) throws ServiceException {
        ValidatorProvider validatorProvider = ValidatorProvider.getInstance();
        UserValidator userValidator = validatorProvider.getUserValidator();

        DAOProvider daoProvider = DAOProvider.getInstance();
        UserDAO userDAO = daoProvider.getUserDAO();
        User authorizedUser = null;

        try {
            if(userValidator.checkAuthData(user)) {
                try {
                    authorizedUser = userDAO.authorization(user);
                }
                catch(DAOException e) {
                    throw new ServiceException("Error while authorization: " + e.getMessage());
                }

                if(authorizedUser == null) {
                    throw new ServiceException("Invalid login or password!");
                }
            }
        }
        catch(ServiceException e) {
            throw new ServiceException(e);
        }

        return authorizedUser;
    }

    @Override
    public boolean updateProfile(User user) throws ServiceException{
        DAOProvider daoProvider = DAOProvider.getInstance();
        UserDAO userDAO = daoProvider.getUserDAO();

        boolean updated = false;
        String userName = user.getUserName();
        try {
            updated = userDAO.updateProfile(user, userName);
            if(!updated) {
                throw new ServiceException(NO_UPDATE_ERROR);
            }
        }
        catch(DAOException e) {
            throw new ServiceException(e);
        }

        return updated;
    }
}
