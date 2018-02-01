package liashenko.airline.model.persistence.storage;

import liashenko.airline.model.persistence.exceptions.PersistenceException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertTrue;

public class AirplaneProducerTest {
    private static AirplaneProducer airplaneProducer;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void init() {
        airplaneProducer = AirplaneProducer.getInstance();
    }

    @AfterClass
    public static void destroy() {
        airplaneProducer = null;
    }

    @Test
    public void failsIfProducerIsNull() {
        thrown.expect(PersistenceException.class);
        thrown.expectMessage("Wrong parameter");
        airplaneProducer.getNewAirplane(null, "");
    }

    @Test
    public void failsIfModelIsNull() {
        thrown.expect(PersistenceException.class);
        thrown.expectMessage("Wrong parameter");
        airplaneProducer.getNewAirplane("", null);
    }

    @Test
    public void returnsTrueOnSave() {
        assertTrue(airplaneProducer.saveData());
    }
}
