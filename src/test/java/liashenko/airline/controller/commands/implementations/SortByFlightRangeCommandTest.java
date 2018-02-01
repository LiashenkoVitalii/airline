package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.model.service.ServiceFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class SortByFlightRangeCommandTest {
    private static Command command;

    @BeforeClass
    public static void init() {
        ServiceFactory serviceFactory = mock(ServiceFactory.class);
        command = new SortByFlightRangeCommand(serviceFactory);
    }

    @AfterClass
    public static void destroy() {
        command = null;
    }

    @Test
    public void returnsExpectedMessageIfArrayHasMoreThanTwoParameters() {
        String[] arr1 = {"one", "two", "three"};
        assertEquals("Wrong count of params", command.handle(arr1));
    }

    @Test
    public void returnsExpectedMessageIfArrayHasLassThanTwoParameters() {
        String[] arr1 = {"one"};
        assertEquals("Wrong count of params", command.handle(arr1));
    }
}
