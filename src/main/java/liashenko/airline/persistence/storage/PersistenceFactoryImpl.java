package liashenko.airline.persistence.storage;

import liashenko.airline.persistence.PersistenceFactory;

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
