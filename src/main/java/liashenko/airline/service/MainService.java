package liashenko.airline.service;

import java.util.Optional;

public interface MainService {

    boolean saveData();

    Optional<String> calculateCapacity();

    Optional<String> getAirlineAircraftByFuelConsumptionParam(Integer integer);

    Optional<String> getAirlineAirplanesSortedByFlightRange();

    Optional<String> getAirlineAirplanesList();

    boolean addNewAirplaneToAirlineFleet(String producer, String model);

    boolean removeAirplaneFromAirlineFleet(Long airplaneSerialNumber);

    Optional<String> showAllAvailableAirplanesModels();
}
