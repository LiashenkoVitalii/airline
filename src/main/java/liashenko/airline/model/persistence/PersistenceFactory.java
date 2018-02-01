package liashenko.airline.model.persistence;

import liashenko.airline.model.persistence.storage.AirlinePark;
import liashenko.airline.model.persistence.storage.AirplaneProducer;

//provides opportunity to work with different persistence implementations
public interface PersistenceFactory {

    AirplaneProducer getAirplaneProducer();

    AirlinePark getAirlinePark();
}
