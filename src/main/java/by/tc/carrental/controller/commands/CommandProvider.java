package by.tc.carrental.controller.commands;

import by.tc.carrental.controller.commands.impl.*;

import java.util.HashMap;

public class CommandProvider {
    private HashMap<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.LOADMAINPAGE, new LoadMainPage());
        commands.put(CommandName.LOADREGISTRATIONPAGE, new LoadRegistrationPage());
        commands.put(CommandName.LOADAUTHORIZATIONPAGE, new LoadAuthorizationPage());
        commands.put(CommandName.REGISTRATION, new Registration());
        commands.put(CommandName.AUTHORIZATION, new Authorization());

    }

    public Command takeCommand(String name) {
        CommandName commandName;

        commandName = CommandName.valueOf(name.toUpperCase());

        return commands.get(commandName);
    }
}
