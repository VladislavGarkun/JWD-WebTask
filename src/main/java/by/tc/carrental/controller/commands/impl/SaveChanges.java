package by.tc.carrental.controller.commands.impl;

import by.tc.carrental.controller.commands.Command;
import by.tc.carrental.model.entity.User;
import by.tc.carrental.model.service.ServiceException;
import by.tc.carrental.model.service.ServiceProvider;
import by.tc.carrental.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SaveChanges implements Command {
    private static final String NAME_PARAM = "name";
    private static final String SURNAME_PARAM = "surname";
    private static final String USERNAME_PARAM = "userName";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";

    private static final String AUTH_ATTRIBUTE = "authorization";
    private static final String USER_ATTRIBUTE = "user";

    private static final String LOAD_MAIN_PAGE_WITH_ERROR = "Controller?command=loadmainpage&message=Session is expired!";
    private static final String LOAD_MAIN_PAGE = "Controller?command=loadmainpage&message=";
    private static final String LOAD_PROFILE_PAGE = "Controller?command=loadprofilepage";
    private static final String NO_UPD_MESSAGE = "Error while updating profile description! Changes are not saved";

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        /*if(session == null)
        {
            response.sendRedirect(LOAD_MAIN_PAGE_WITH_ERROR);
        }*/

        if(session.getAttribute(AUTH_ATTRIBUTE) != null && session.getAttribute(USER_ATTRIBUTE) != null) {
            //User user = (User)session.getAttribute(USER_ATTRIBUTE);

            String name = request.getParameter(NAME_PARAM);
            String surname = request.getParameter(SURNAME_PARAM);
            String userName = request.getParameter(USERNAME_PARAM);
            String phoneNumber = request.getParameter(PHONE_NUMBER);
            String login = request.getParameter(LOGIN_PARAM);
            String password = request.getParameter(PASSWORD_PARAM);
            User user = new User( login, password, name, surname, userName, phoneNumber);

            ServiceProvider serviceProvider = ServiceProvider.getInstance();
            UserService userService = serviceProvider.getUserService();

            boolean updatedDesc = false;
            try {
                updatedDesc = userService.updateProfile(user);
                if(!updatedDesc) {
                    response.sendRedirect(LOAD_MAIN_PAGE+NO_UPD_MESSAGE);
                }

                //user.setProfileDecs(newProfileDesc);
                response.sendRedirect(LOAD_PROFILE_PAGE);
            }
            catch(ServiceException e) {
                response.sendRedirect(LOAD_MAIN_PAGE+e.getMessage());
            }
        }
        else {
            response.sendRedirect(LOAD_MAIN_PAGE_WITH_ERROR);
        }
    }
}
