package by.tc.carrental.model.service.validation.impl;

import by.tc.carrental.model.entity.User;
import by.tc.carrental.model.service.ServiceException;
import by.tc.carrental.model.service.validation.UserValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidatorImpl implements UserValidator {
    private static final String EMPTY_NAME = "Enter name!";
    private static final String EMPTY_PHONE = "Enter phone number";
    private static final String EMPTY_LOGIN = "Enter login!";
    private static final String EMPTY_PASSWORD = "Enter password!";
    private static final String SHORT_PASSWORD = "The password is too short!";
    private static final String LONG_PASSWORD = "The password is too long!";
    private static final String LONG_USERNAME = "The username is too long!";
    private static final String INVALID_NAME = "name must contain only letters and numbers!";
    private static final String INVALID_LOGIN = "Invalid format of login!";

    private static final String CHARACTERS_AND_NUMBERS = "[A-Z0-9]+";
    private static final String EMAIL_FORMAT = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 30;

    @Override
    public boolean checkAuthData(User user) throws ServiceException {
        if(user.getFirstName().isEmpty() || user.getFirstName() == null) {
            throw new ServiceException(EMPTY_NAME);
        }

        if(user.getLastName().isEmpty() || user.getLastName() == null) {
            throw new ServiceException(EMPTY_NAME);
        }

        if(user.getPhoneNumber().isEmpty() || user.getPhoneNumber() == null) {
            throw new ServiceException(EMPTY_NAME);
        }

        if(user.getLogin().isEmpty() || user.getLogin() == null) {
            throw new ServiceException(EMPTY_NAME);
        }

        if(user.getPassword().isEmpty() || user.getPassword() == null) {
            throw new ServiceException(EMPTY_PASSWORD);
        }

        if(user.getPassword().length() < MIN_LENGTH) {
            throw new ServiceException(SHORT_PASSWORD);
        }

        if(user.getPassword().length() > MAX_LENGTH) {
            throw new ServiceException(LONG_PASSWORD);
        }

        if(user.getFirstName().length() > MAX_LENGTH) {
            throw new ServiceException(LONG_USERNAME);
        }

        Pattern usernamePattern = Pattern.compile(CHARACTERS_AND_NUMBERS);
        Matcher usernameMatcher = usernamePattern.matcher(user.getFirstName());

        if(!usernameMatcher.find()) {
            throw new ServiceException(INVALID_NAME);
        }

        return true;
    }

    public boolean checkRegData(User user) throws ServiceException {
        if(checkAuthData(user)) {
            if(user.getLogin().isEmpty() || user.getLogin() == null) {
                throw new ServiceException(EMPTY_LOGIN);
            }

            Pattern emailPattern = Pattern.compile(EMAIL_FORMAT);
            Matcher emailMatcher = emailPattern.matcher(user.getLogin());

            if(!emailMatcher.find()) {
                throw new ServiceException(INVALID_LOGIN);
            }
        }

        return true;
    }
}
