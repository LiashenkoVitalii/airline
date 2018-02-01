package liashenko.airline.controller;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.model.persistence.exceptions.PersistenceException;
import org.apache.log4j.Logger;

//resolves users commands and returns result of their processing
public abstract class CommandsHandler {
    private static final Logger logger = Logger.getLogger(CommandsHandler.class);

    private static final CommandsHelper COMMANDS_HELPER = CommandsHelper.getInstance();

    private static String[] enterUsersCommand(String str) {
        str = str.trim();
        return str.split(" ");
    }

    public static String handleCommand(String str) throws PersistenceException {
        String[] commandsArr = enterUsersCommand(str);
        Command command = COMMANDS_HELPER.getCommand(commandsArr[0].toLowerCase());
        return command.handle(commandsArr);
    }
}
