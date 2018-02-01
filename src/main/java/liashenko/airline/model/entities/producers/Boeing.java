package liashenko.airline.model.entities.producers;

import liashenko.airline.model.entities.Airplane;

//abstract airplane (second level of hierarchy)
public abstract class Boeing extends Airplane {

    public Boeing() {
        this.producer = "The Boeing Company";
    }
}
