package liashenko.airline.model.service;

import java.util.Optional;

//used to provide all needed methods to process user requests related with storage
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
