package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.ICommand;
import org.apache.log4j.Logger;

public class ErrorCommand implements ICommand {
    private static final Logger logger = Logger.getLogger(ErrorCommand.class);

    @Override
    public String handle(String[] arr) {
        return "error";
    }
}
