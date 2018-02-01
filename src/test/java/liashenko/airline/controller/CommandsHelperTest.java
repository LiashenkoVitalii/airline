package liashenko.airline.controller;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.controller.commands.implementations.DefaultCommand;
import liashenko.airline.controller.commands.implementations.ExitCommand;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommandsHelperTest {

    private static CommandsHelper commandsHelper;

    @BeforeClass
    public static void init() {
        commandsHelper = CommandsHelper.getInstance();
    }

    @AfterClass
    public static void destroy() {
        commandsHelper = null;
    }

    @Test
    public void returnedExpectedCommandByAllowedParameter() {
        Command command = commandsHelper.getCommand(CommandsHelper.EXIT_COMMAND);
        assertTrue(command.getClass() == ExitCommand.class);
    }

    @Test
    public void returnedExpectedCommandByNotAllowedParameter() {
        Command command = commandsHelper.getCommand("not_allowed_command");
        assertTrue(command.getClass() == DefaultCommand.class);
    }
}
