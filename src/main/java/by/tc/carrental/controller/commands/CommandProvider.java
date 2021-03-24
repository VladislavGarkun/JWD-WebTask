package by.tc.carrental.controller.commands;

import by.tc.carrental.controller.commands.impl.*;

import java.util.HashMap;

import static by.tc.carrental.controller.commands.CommandName.LOGOUT;

public class CommandProvider {
    private HashMap<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.LOADFIRSTPAGE, new LoadFirstPage());
        commands.put(CommandName.LOADMAINPAGE, new LoadMainPage());
        commands.put(CommandName.REGISTRATION, new Registration());
        commands.put(CommandName.AUTHORIZATION, new Authorization());
        commands.put(CommandName.LOGOUT, new LogOut());
        commands.put(CommandName.LOADPROFILEPAGE, new LoadProfilePage());
        commands.put(CommandName.SAVECHANGES, new SaveChanges());
    }

    public Command takeCommand(String name) {
        CommandName commandName;

        commandName = CommandName.valueOf(name.toUpperCase());

        return commands.get(commandName);
    }
}
