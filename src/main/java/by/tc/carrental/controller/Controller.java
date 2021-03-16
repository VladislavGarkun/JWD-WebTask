package by.tc.carrental.controller;

import by.tc.carrental.controller.commands.Command;
import by.tc.carrental.controller.commands.CommandProvider;
import by.tc.carrental.util.PasswordCoder;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "controller", value = "/controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String COMMAND_PARAM = "command";

    private final CommandProvider provider = new CommandProvider();

    public void init() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String name;
        Command command;

        name = request.getParameter(COMMAND_PARAM);
        command = provider.takeCommand(name);

        command.execute(request, response);

    }
}