package liashenko.airline.persistence.storage;

import liashenko.airline.entities.Airplane;
import liashenko.airline.persistence.exceptions.ReadWriteException;
import liashenko.airline.persistence.utils.DataReadWriteUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.*;

import static liashenko.airline.persistence.utils.DataReadWriteUtils.STORAGE_DIR;

public class AirlinePark {
    private static final Logger logger = Logger.getLogger(AirlinePark.class);

    private final static String STORAGE_PATH = STORAGE_DIR + File.separator + "AirlinePark.bin";
    private static AirlinePark instance;
    private List<Airplane> airplaneFleet = null;

    private AirlinePark() {
        airplaneFleet = new ArrayList<>();
    }

    public static AirlinePark getInstance() {
        if (instance == null) {
            instance = new AirlinePark();
        }
        return instance;
    }

    public boolean addAirplane(Airplane airplane) {
        if (airplane == null) return false;
        airplaneFleet.add(airplane);
        return true;
    }

    public boolean removeAirplane(Airplane airplane) {
        if (airplane == null) return false;
        try {
            airplaneFleet.remove(airplane);
        } catch (NoSuchElementException ex) {
            logger.error(ex.getMessage());
            return false;
        }
        return true;
    }

    public Optional<List<Airplane>> getAirplaneList() {
        if (airplaneFleet == null || airplaneFleet.isEmpty()) return Optional.empty();
        return Optional.of(Collections.unmodifiableList(airplaneFleet));
    }

    public Optional<List<Airplane>> getAirplaneListByParams() {
        if (airplaneFleet == null || airplaneFleet.isEmpty()) return Optional.empty();
        return Optional.of(Collections.unmodifiableList(airplaneFleet));
    }

    @SuppressWarnings("unchecked")
    public boolean loadData() {
        try {
            airplaneFleet = (ArrayList<Airplane>) DataReadWriteUtils.read(STORAGE_PATH);
        } catch (ReadWriteException ex) {
            logger.error(ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean saveData() {
        try {
            return DataReadWriteUtils.write(airplaneFleet, STORAGE_PATH);
        } catch (ReadWriteException e) {
            logger.error(e.getMessage());
            return false;
        }
    }
}
