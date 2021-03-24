package by.tc.carrental.controller.commands.impl;

import by.tc.carrental.controller.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOut implements Command {
    private static final String LOAD_FIRST_PAGE = "Controller?command=loadfirstpage";
    private static final String AUTH_ATTRIBUTE = "authorization";

    public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        if(session != null)
        {
            session.removeAttribute(AUTH_ATTRIBUTE);
        }

        response.sendRedirect(LOAD_FIRST_PAGE);
    }
}
