package liashenko.airline.controller;

import liashenko.airline.controller.commands.ICommand;
import liashenko.airline.persistence.exceptions.PersistenceException;
import org.apache.log4j.Logger;

public abstract class CommandsHandler {
    private static final Logger logger = Logger.getLogger(CommandsHandler.class);

    private static final CommandsHelper COMMANDS_HELPER = CommandsHelper.getInstance();

    private static String[] enterUsersCommand(String str) {
        str = str.trim();
        return str.split(" ");
    }

    public static String handleCommand(String str) throws PersistenceException {
        String[] commandsArr = enterUsersCommand(str);
        ICommand command = COMMANDS_HELPER.getCommand(commandsArr[0].toLowerCase());
        return command.handle(commandsArr);
    }
}
