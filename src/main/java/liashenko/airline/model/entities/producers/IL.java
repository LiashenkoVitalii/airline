package liashenko.airline.model.entities.producers;

import liashenko.airline.model.entities.Airplane;

//abstract airplane (second level of hierarchy)
public abstract class IL extends Airplane {

    public IL() {
        this.producer = "Ilyushin Design Bureau";
    }
}
