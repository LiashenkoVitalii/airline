package liashenko.airline.persistence.storage;

import liashenko.airline.entities.Airplane;
import liashenko.airline.entities.long_haul.airbus.AirBusA310_300;
import liashenko.airline.entities.long_haul.airbus.AirBusA330_200;
import liashenko.airline.entities.long_haul.boeing.Boeing747;
import liashenko.airline.entities.long_haul.boeing.Boeing777;
import liashenko.airline.entities.long_haul.il.IL62;
import liashenko.airline.entities.long_haul.il.IL96_300;
import liashenko.airline.entities.long_haul.il.IL_96M;
import liashenko.airline.entities.medium_haul.airbus.AirBusA320_200;
import liashenko.airline.entities.medium_haul.boeing.Boeing737;
import liashenko.airline.entities.medium_haul.boeing.Boeing767;
import liashenko.airline.entities.medium_haul.il.IL86;
import liashenko.airline.entities.medium_haul.tu.Tu154;
import liashenko.airline.entities.short_haul.tu.Tu134;
import liashenko.airline.persistence.exceptions.PersistenceException;
import liashenko.airline.persistence.exceptions.ReadWriteException;
import liashenko.airline.persistence.utils.DataReadWriteUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static liashenko.airline.persistence.utils.DataReadWriteUtils.STORAGE_DIR;

public class AirplaneProducer {
    private static final Logger logger = Logger.getLogger(AirplaneProducer.class);

    private final static String AIRPLANES_STORAGE_PATH = STORAGE_DIR + File.separator + "Airplanes.bin";
    private final static String AIRPLANES_UNIQUE_SERIAL_NUM_STORAGE_PATH = STORAGE_DIR + File.separator + "serialNumber.bin";
    private static AirplaneProducer instance = null;
    private Long uniqueSerialNumber = 0L;
    private Set<Airplane> airplaneSet = new HashSet<>();

    private AirplaneProducer() {
        initAirplaneSet(airplaneSet);
    }

    public static AirplaneProducer getInstance() {
        if (instance == null) {
            instance = new AirplaneProducer();
        }
        return instance;
    }

    private void initAirplaneSet(Set<Airplane> airplaneSet) {
        airplaneSet.add(new AirBusA310_300());
        airplaneSet.add(new AirBusA330_200());
        airplaneSet.add(new Boeing747());
        airplaneSet.add(new Boeing777());
        airplaneSet.add(new IL62());
        airplaneSet.add(new IL96_300());
        airplaneSet.add(new IL_96M());
        airplaneSet.add(new AirBusA320_200());
        airplaneSet.add(new Boeing737());
        airplaneSet.add(new Boeing767());
        airplaneSet.add(new IL86());
        airplaneSet.add(new Tu154());
        airplaneSet.add(new Tu134());
    }

    public Optional<Airplane> getNewAirplane(String producer, String model) {
        Airplane airplane = getAirplaneByParams(producer, model);
        if (airplane == null) return Optional.empty();
        airplane.setSerialNumber(getUniqueSerialNumber());
        try {
            return Optional.of(airplane.clone());
        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage());
            throw new PersistenceException("Couldn't create new airplane");
        }
    }

    private Airplane getAirplaneByParams(String producer, String model) {
        if (producer == null || model == null || producer.isEmpty() || model.isEmpty()) {
            throw new PersistenceException("Wrong method parameters");
        }

        List<Airplane> airplaneList = airplaneSet.parallelStream()
                .filter(aircraft -> (aircraft.getProducer().equals(producer) && aircraft.getModelName().equals(model)))
                .collect(Collectors.toList());
        if (airplaneList == null || airplaneList.isEmpty()) return null;
        if (airplaneList.size() > 1) throw new PersistenceException("More than one parameter found");
        return airplaneList.get(0);
    }

    public Optional<Set<Airplane>> getAirplaneSet() {
        if (airplaneSet == null || airplaneSet.isEmpty()) return Optional.empty();
        return Optional.of(Collections.unmodifiableSet(airplaneSet));
    }

    @SuppressWarnings("unchecked")
    public boolean loadData() {
        try {
            airplaneSet = (HashSet<Airplane>) DataReadWriteUtils.read(AIRPLANES_STORAGE_PATH);
            uniqueSerialNumber = (Long) DataReadWriteUtils.read(AIRPLANES_UNIQUE_SERIAL_NUM_STORAGE_PATH);
        } catch (ReadWriteException ex) {
            logger.error(ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean saveData() {
        try {
            return (DataReadWriteUtils.write(airplaneSet, AIRPLANES_STORAGE_PATH)
                    && DataReadWriteUtils.write(uniqueSerialNumber, AIRPLANES_UNIQUE_SERIAL_NUM_STORAGE_PATH));
        } catch (ReadWriteException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    private Long getUniqueSerialNumber() {
        return ++uniqueSerialNumber;
    }
}