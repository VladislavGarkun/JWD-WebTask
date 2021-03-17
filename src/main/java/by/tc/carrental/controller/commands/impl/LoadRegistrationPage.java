package by.tc.carrental.controller.commands.impl;

import by.tc.carrental.controller.commands.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoadRegistrationPage implements Command {
    private static final String REGISTRATION_PAGE_PATH = "/jsp/user/registration.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(REGISTRATION_PAGE_PATH);
        requestDispatcher.forward(request, response);
    }
}
