package liashenko.airline.model.entities.producers;

import liashenko.airline.model.entities.Airplane;

//abstract airplane (second level of hierarchy)
public abstract class Tu extends Airplane {

    public Tu() {
        this.producer = "Tupolev Design Bureau";
    }
}
