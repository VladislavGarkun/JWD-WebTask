package by.tc.carrental.model.service.validation;

import by.tc.carrental.model.service.validation.impl.UserValidatorImpl;

public class ValidatorProvider {
    private static final ValidatorProvider instance = new ValidatorProvider();

    private ValidatorProvider() {}

    private final UserValidator userValidator = new UserValidatorImpl();

    public static ValidatorProvider getInstance() {
        return instance;
    }

    public UserValidator getUserValidator() {
        return userValidator;
    }
}
