package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.Command;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ErrorCommandTest {
    private static Command command;

    @BeforeClass
    public static void init() {
        command = new ErrorCommand();
    }

    @AfterClass
    public static void destroy() {
        command = null;
    }

    @Test
    public void returnsExpectedMessageAfterHandling() {
        String[] arr = null;
        String[] arr2 = {"one"};
        String[] arr3 = {""};
        assertEquals("We got an error", command.handle(arr));
        assertEquals("We got an error", command.handle(arr2));
        assertEquals("We got an error", command.handle(arr3));
    }
}
