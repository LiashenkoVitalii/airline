package liashenko.airline.model.entities.producers;

import liashenko.airline.model.entities.Airplane;

//abstract airplane (second level of the aircraft hierarchy)
public abstract class AirBus extends Airplane {

    public AirBus() {
        this.producer = "Airbus S.A.S.";
    }
}
