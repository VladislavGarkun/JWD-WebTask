package by.tc.carrental.controller.commands.impl;

import by.tc.carrental.controller.commands.Command;
import by.tc.carrental.model.service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoadMainPage implements Command {
    private static final String MAIN_PAGE_PATH = "/jsp/user/main_page.jsp";
    private static final String ERROR_PAGE_PATH = "/jsp/error_page_global.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceProvider serviceProvider = ServiceProvider.getInstance();

        //try{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(MAIN_PAGE_PATH);
        requestDispatcher.forward(request, response);
        /*}catch (ServiceException ex){
            String errorMessage = ex.getMessage();
            request.setAttribute("message", errorMessage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher((ERROR_PAGE_PATH));
            requestDispatcher.forward(request, response);

        }*/
    }
}
