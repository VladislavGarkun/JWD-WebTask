package by.tc.carrental.controller.commands.impl;

import by.tc.carrental.controller.commands.Command;
import by.tc.carrental.model.entity.User;
import by.tc.carrental.model.service.ServiceException;
import by.tc.carrental.model.service.ServiceProvider;
import by.tc.carrental.model.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration implements Command {
    private static final String NAME_PARAM = "name";
    private static final String SURNAME_PARAM = "surname";
    private static final String USERNAME_PARAM = "userName";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String LOGIN_PARAM = "login_2";
    private static final String PASSWORD_PARAM = "password_2";
    private static final String DATE_OF_BIRTH_PARAM = "birthDate";
    private static final String NUMBER_OF_PASSPORT_PARAM = "passportNumber";

    private static final String LOAD_MAIN_PAGE = "Controller?command=loadmainpage";
    private static final String FIRST_PAGE_PATH = "/jsp/user/first_page.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter(NAME_PARAM);
        String surname = request.getParameter(SURNAME_PARAM);
        String userName = request.getParameter(USERNAME_PARAM);
        String phoneNumber = request.getParameter(PHONE_NUMBER);
        String login = request.getParameter(LOGIN_PARAM);
        String password = request.getParameter(PASSWORD_PARAM);
        String dateOfBirth = request.getParameter(DATE_OF_BIRTH_PARAM);
        String numberOfPassport = request.getParameter(NUMBER_OF_PASSPORT_PARAM);

        User user = new User( login, password, name, surname, userName, phoneNumber);
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        UserService userService = serviceProvider.getUserService();

        try {
            if(userService.registration(user)) {
                response.sendRedirect(LOAD_MAIN_PAGE);
            }
        }
        catch(ServiceException e) {
            request.setAttribute("message", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(FIRST_PAGE_PATH);
            requestDispatcher.forward(request, response);
        }
    }
}
