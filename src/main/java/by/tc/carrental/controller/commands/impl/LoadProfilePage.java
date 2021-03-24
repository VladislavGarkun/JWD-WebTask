package by.tc.carrental.controller.commands.impl;

import by.tc.carrental.controller.commands.Command;
import by.tc.carrental.model.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoadProfilePage implements Command {
    private static final String AUTHORIZATION_ATTRIBUTE = "authorization";
    private static final String USER_ATTRIBUTE = "user";
    private static final String PROFILE_PAGE_PATH = "/jsp/user/profile_page.jsp";

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession httpSession = request.getSession();

        if(httpSession == null){

        }

        if(httpSession.getAttribute(AUTHORIZATION_ATTRIBUTE) != null && httpSession.getAttribute(USER_ATTRIBUTE) != null){
            User user = (User)httpSession.getAttribute(USER_ATTRIBUTE);

            try {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(PROFILE_PAGE_PATH);
                requestDispatcher.forward(request, response);
            }catch (ServletException ex){

            }
        }
    }
}
