package liashenko.airline.model.service.implementation;

import liashenko.airline.model.entities.Airplane;
import liashenko.airline.model.persistence.PersistenceFactory;
import liashenko.airline.model.persistence.exceptions.PersistenceException;
import liashenko.airline.model.service.MainService;
import liashenko.airline.model.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class MainServiceImpl implements MainService {
    private final static Logger logger = Logger.getLogger(MainServiceImpl.class);
    private PersistenceFactory persistenceFactory;

    public MainServiceImpl(PersistenceFactory persistenceFactory) {
        this.persistenceFactory = persistenceFactory;
        loadPersistenceData();
    }

    private void loadPersistenceData() {
        try {
            persistenceFactory.getAirplaneProducer().loadData();
            persistenceFactory.getAirlinePark().loadData();
        } catch (PersistenceException ex) {
            logger.error(ex.getMessage());
            throw new ServiceException("Couldn't load data");
        }
    }

    @Override
    public boolean saveData() {
        try {
            if (!persistenceFactory.getAirplaneProducer().saveData()) return false;
            if (!persistenceFactory.getAirlinePark().saveData()) return false;
            return true;
        } catch (PersistenceException ex) {
            logger.error(ex.getMessage());
            throw new ServiceException("Couldn't save data");
        }
    }

    @Override
    public Optional<String> calculateCapacity() {
        StringBuilder sb = new StringBuilder();
        AtomicLong totalCapacity = new AtomicLong(0);
        AtomicLong carryingCapacity = new AtomicLong(0);

        persistenceFactory.getAirlinePark().getAirplaneList()
                .ifPresent(airplanes -> airplanes.parallelStream().forEach(airplane -> {
                    totalCapacity.getAndAdd(airplane.getTotalCapacity());
                    carryingCapacity.getAndAdd(airplane.getCarryingCapacity());

                }));

        sb.append(String.format("total capacity is: %d person", totalCapacity.intValue())).append("\n");
        sb.append(String.format("carrying capacity is: %d kg or %d  tons",
                carryingCapacity.intValue(),
                carryingCapacity.intValue() / 1000)).append("\n");
        return Optional.of(sb.toString());
    }

    @Override
    public Optional<String> getAirlineAircraftByFuelConsumptionParam(Integer fuelConsumption) {
        if (fuelConsumption == null || fuelConsumption < 0) throw new ServiceException("Wrong parameter");
        StringBuilder sb = new StringBuilder();
        persistenceFactory.getAirlinePark().getAirplaneList()
                .ifPresent(airplanes -> airplanes.parallelStream()
                        .filter(airplane -> airplane.getFuelConsumption().equals(fuelConsumption))
                        .forEach(airplane -> sb.append(airplane.getDescription()).append("\n")));
        return (sb.length() > 0) ? Optional.of(sb.toString()) : Optional.empty();
    }

    @Override
    public Optional<String> getAirlineAirplanesSortedByFlightRange() {
        StringBuilder sb = new StringBuilder();
        persistenceFactory.getAirlinePark().getAirplaneList()
                .ifPresent(airplanes -> airplanes.parallelStream().sorted(getFlightRangeComparator())
                        .forEachOrdered(aircraft -> sb.append(aircraft.getDescription()).append("\n")));

        return (sb.length() > 0) ? Optional.of(sb.toString()) : Optional.empty();
    }

    @Override
    public Optional<String> getAirlineAirplanesList() {
        StringBuilder sb = new StringBuilder();
        persistenceFactory.getAirlinePark().getAirplaneList()
                .ifPresent(airplanes -> airplanes.parallelStream().sorted(getProducerAndModelComparator())
                        .forEachOrdered(airplane -> sb.append(airplane.getDescription()).append("\n")));
        return (sb.length() > 0) ? Optional.of(sb.toString()) : Optional.empty();
    }

    @Override
    public boolean addNewAirplaneToAirlineFleet(String producer, String model) {
        if (producer == null || model == null) throw new ServiceException("Wrong parameter");
        Optional<Airplane> airplaneOpt = persistenceFactory.getAirplaneProducer().getNewAirplane(producer, model);
        if (airplaneOpt.isPresent()) {
            return persistenceFactory.getAirlinePark().addAirplane(airplaneOpt.get());
        } else {
            return false;
        }
    }

    @Override
    public boolean removeAirplaneFromAirlineFleet(Long airplaneSerialNumber) {
        if (airplaneSerialNumber == null || airplaneSerialNumber < 0) throw new ServiceException("Wrong parameter");
        Optional<List<Airplane>> airplanesOpt = persistenceFactory.getAirlinePark().getAirplaneList();
        if (airplanesOpt.isPresent()) {
            List<Airplane> foundAirplanes = airplanesOpt.get().parallelStream()
                    .filter(airplane -> airplane.getSerialNumber().equals(airplaneSerialNumber))
                    .collect(Collectors.toList());
            if (foundAirplanes == null || foundAirplanes.size() == 0) return false;
            if (foundAirplanes.size() > 1) throw new ServiceException("More than one result found");
            return persistenceFactory.getAirlinePark().removeAirplane(foundAirplanes.get(0));
        } else {
            return false;
        }
    }

    @Override
    public Optional<String> showAllAvailableAirplanesModels() {
        StringBuilder sb = new StringBuilder();
        persistenceFactory.getAirplaneProducer().getAirplaneSet()
                .ifPresent(airplanes -> airplanes.parallelStream().sorted(getProducerAndModelComparator())
                        .forEachOrdered(airplane -> sb.append(airplane.getDescription()).append("\n")));

        return (sb.length() > 0) ? Optional.of(sb.toString()) : Optional.empty();
    }

    private Comparator<Airplane> getProducerComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if (o != null && t1 != null) {
                    if ((o instanceof Airplane) && (t1 instanceof Airplane)) {
                        Airplane left = (Airplane) o;
                        Airplane right = (Airplane) t1;
                        return left.getProducer().compareTo(right.getProducer());

                    }
                }
                return 0;
            }
        };
    }

    private Comparator<Airplane> getModelComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if (o != null && t1 != null) {
                    if ((o instanceof Airplane) && (t1 instanceof Airplane)) {
                        Airplane left = (Airplane) o;
                        Airplane right = (Airplane) t1;
                        return left.getModelName().compareTo(right.getModelName());

                    }
                }
                return 0;
            }
        };
    }

    private Comparator<Airplane> getProducerAndModelComparator() {
        return getProducerComparator().thenComparing(getModelComparator());
    }

    private Comparator<Airplane> getFlightRangeComparator() {
        return new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if (o != null && t1 != null) {
                    if ((o instanceof Airplane) && (t1 instanceof Airplane)) {
                        Airplane left = (Airplane) o;
                        Airplane right = (Airplane) t1;
                        return left.getFlightRange().compareTo(right.getFlightRange());

                    }
                }
                return 0;
            }
        };
    }
}
