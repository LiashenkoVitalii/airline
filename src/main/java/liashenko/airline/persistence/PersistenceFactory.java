package liashenko.airline.persistence;

import liashenko.airline.persistence.storage.AirlinePark;
import liashenko.airline.persistence.storage.AirplaneProducer;

public interface PersistenceFactory {

    AirplaneProducer getAirplaneProducer();

    AirlinePark getAirlinePark();
}
