package liashenko.airline.model.service;

import liashenko.airline.model.persistence.PersistenceFactory;
import liashenko.airline.model.persistence.storage.AirlinePark;
import liashenko.airline.model.persistence.storage.AirplaneProducer;
import liashenko.airline.model.service.exceptions.ServiceException;
import liashenko.airline.model.service.implementation.MainServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainServiceTest {

    private static MainService mainService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void init() {
        PersistenceFactory persistenceFactory = mock(PersistenceFactory.class);
        when(persistenceFactory.getAirplaneProducer()).thenReturn(AirplaneProducer.getInstance());
        when(persistenceFactory.getAirlinePark()).thenReturn(AirlinePark.getInstance());
        mainService = new MainServiceImpl(persistenceFactory);
    }

    @AfterClass
    public static void destroy() {
        mainService = null;
    }

    @Test
    public void failsWithExpectedExceptionIfConsumptionParamIsNull() {
        thrown.expect(ServiceException.class);
        thrown.expectMessage("Wrong parameter");
        mainService.getAirlineAircraftByFuelConsumptionParam(null);
    }

    @Test
    public void failsWithExpectedExceptionIfConsumptionParamIsLessThan_0() {
        thrown.expect(ServiceException.class);
        thrown.expectMessage("Wrong parameter");
        mainService.getAirlineAircraftByFuelConsumptionParam(-2);
    }

    @Test
    public void failsWithExpectedExceptionIfProducerIsNull() {
        thrown.expect(ServiceException.class);
        thrown.expectMessage("Wrong parameter");
        mainService.addNewAirplaneToAirlineFleet(null, "");
    }

    @Test
    public void failsWithExpectedExceptionIfModelIsLessIsNull() {
        thrown.expect(ServiceException.class);
        thrown.expectMessage("Wrong parameter");
        mainService.addNewAirplaneToAirlineFleet("", null);
    }

    @Test
    public void failsWithExpectedExceptionIfSerialNumberIsNull() {
        thrown.expect(ServiceException.class);
        thrown.expectMessage("Wrong parameter");
        mainService.removeAirplaneFromAirlineFleet(null);
    }

    @Test
    public void failsWithExpectedExceptionIfSerialNumberIsLessThan_0() {
        thrown.expect(ServiceException.class);
        thrown.expectMessage("Wrong parameter");
        mainService.removeAirplaneFromAirlineFleet(-2L);
    }
}
