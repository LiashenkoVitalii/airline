package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.model.service.ServiceFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class DefaultCommandTest {
    private static Command command;

    @BeforeClass
    public static void init() {
        ServiceFactory serviceFactory = mock(ServiceFactory.class);
        command = new DefaultCommand(serviceFactory);
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
        assertEquals("This command doesn't exist", command.handle(arr));
        assertEquals("This command doesn't exist", command.handle(arr2));
        assertEquals("This command doesn't exist", command.handle(arr3));
    }
}
