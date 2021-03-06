package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.controller.commands.Help;
import org.apache.log4j.Logger;

import java.util.stream.Stream;

//used to print the list of available commands on the screen
public class HelpCommand implements Command {
    private static final Logger logger = Logger.getLogger(HelpCommand.class);

    @Override
    public String handle(String[] arr) {
        StringBuilder sb = new StringBuilder();
        Stream.of(Help.COMMANDS_LIST).forEach(command -> sb.append(command).append("\n"));
        return sb.length() > 0 ? sb.toString() : "";
    }
}
