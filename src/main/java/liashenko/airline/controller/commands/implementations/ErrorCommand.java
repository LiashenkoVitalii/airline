package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.Command;
import org.apache.log4j.Logger;

//can be used in case internal error happens
public class ErrorCommand implements Command {
    private static final Logger logger = Logger.getLogger(ErrorCommand.class);

    @Override
    public String handle(String[] arr) {
        return "We got an error";
    }
}
