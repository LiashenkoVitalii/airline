package liashenko.airline.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandsHandlerTest {

    @Test
    public void returnsExpectedMessageIfInputIsEmpty() {
        assertEquals("This command doesn't exist", CommandsHandler.handleCommand(""));
    }

    @Test
    public void returnsExpectedMessageIfInputHasNonExistingCommand() {
        assertEquals("This command doesn't exist", CommandsHandler.handleCommand("some_command"));
    }

    @Test
    public void returnsExpectedMessageIfInputHasWrongParametersCount() {
        assertEquals("Wrong count of params", CommandsHandler.handleCommand("save to"));
    }
}
