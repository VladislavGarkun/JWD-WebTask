package by.tc.carrental.controller.commands;

import by.tc.carrental.controller.commands.impl.LoadMainPage;
import by.tc.carrental.controller.commands.impl.LoadRegistrationPage;

import java.util.HashMap;

public class CommandProvider {
    private HashMap<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.LOADMAINPAGE, new LoadMainPage());
        commands.put(CommandName.LOADREGISTRATIONPAGE, new LoadRegistrationPage());
        commands.put(CommandName.REGISTRATION, new LoadRegistrationPage());
    }

    public Command takeCommand(String name) {
        CommandName commandName;

        commandName = CommandName.valueOf(name.toUpperCase());

        return commands.get(commandName);
    }
}