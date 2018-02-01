package liashenko.airline.model.persistence.storage;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class AirlineParkTest {

    private static AirlinePark airlinePark;

    @BeforeClass
    public static void init() {
        airlinePark = AirlinePark.getInstance();
    }

    @AfterClass
    public static void destroy() {
        airlinePark = null;
    }

    @Test
    public void returnsTrueOnSave() {
        assertTrue(airlinePark.saveData());
    }

    @Test
    public void returnsFalseIfAirplaneToAddIsNull() {
        assertFalse(airlinePark.addAirplane(null));
    }

    @Test
    public void returnsFalseIfAirplaneToRemoveIsNull() {
        assertFalse(airlinePark.removeAirplane(null));
    }
}