package liashenko.airline.model.persistence.storage;

import liashenko.airline.model.persistence.PersistenceFactory;

public class PersistenceFactoryImpl implements PersistenceFactory {

    @Override
    public AirplaneProducer getAirplaneProducer() {
        return AirplaneProducer.getInstance();
    }

    @Override
    public AirlinePark getAirlinePark() {
        return AirlinePark.getInstance();
    }
}
