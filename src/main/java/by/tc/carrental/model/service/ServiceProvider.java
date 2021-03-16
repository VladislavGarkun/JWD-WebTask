package by.tc.carrental.model.service;

import by.tc.carrental.model.service.impl.UserServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private ServiceProvider(){}

    private final UserService userService = new UserServiceImpl();

    public static ServiceProvider getInstance(){
        return instance;
    }

    public UserService getUserService(){
        return userService;
    }
}
