package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.model.service.ServiceFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class AddCommandTest {
    private static Command command;

    @BeforeClass
    public static void init() {
        ServiceFactory serviceFactory = mock(ServiceFactory.class);
        command = new AddCommand(serviceFactory);
    }

    @AfterClass
    public static void destroy() {
        command = null;
    }

    @Test
    public void returnsExpectedMessageIfArrayHasMoreThanFiveParameters() {
        String[] arr = {"one", "two", "three", "four", "five", "six"};
        assertEquals("Wrong count of params", command.handle(arr));
    }

    @Test
    public void returnsExpectedMessageIfArrayHasLessThanFiveParameters() {
        String[] arr = {"one", "two", "three", "four"};
        assertEquals("Wrong count of params", command.handle(arr));
    }
}
