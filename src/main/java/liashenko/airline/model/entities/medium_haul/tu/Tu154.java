package liashenko.airline.model.entities.medium_haul.tu;

import liashenko.airline.model.entities.medium_haul.MediumHaul;
import liashenko.airline.model.entities.producers.Tu;

public class Tu154 extends Tu implements MediumHaul {
    private static final long serialVersionUID = 1L;

    public Tu154() {
        this.modelName = "Tu-154";
        this.flightRange = validateFlightRange(5_200);
        this.carryingCapacity = 18_000;
        this.maxFlightHeight = 11_000;
        this.cruiseSpeed = 950;
        this.fuelConsumption = 6_200;
        this.haulType = HAULS.MEDIUM_HAUL;
    }

    @Override
    public Integer getTotalCapacity() {
        return 180;
    }

    @Override
    public Tu154 clone() throws CloneNotSupportedException {
        return (Tu154) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tu154)) return false;

        Tu154 airplane = (Tu154) o;

        if (serialNumber != null ? !serialNumber.equals(airplane.serialNumber) : airplane.serialNumber != null)
            return false;
        if (modelName != null ? !modelName.equals(airplane.modelName) : airplane.modelName != null) return false;
        if (producer != null ? !producer.equals(airplane.producer) : airplane.producer != null) return false;
        if (flightRange != null ? !flightRange.equals(airplane.flightRange) : airplane.flightRange != null)
            return false;
        if (carryingCapacity != null ? !carryingCapacity.equals(airplane.carryingCapacity) : airplane.carryingCapacity != null)
            return false;
        if (maxFlightHeight != null ? !maxFlightHeight.equals(airplane.maxFlightHeight) : airplane.maxFlightHeight != null)
            return false;
        if (cruiseSpeed != null ? !cruiseSpeed.equals(airplane.cruiseSpeed) : airplane.cruiseSpeed != null)
            return false;
        return fuelConsumption != null ? fuelConsumption.equals(airplane.fuelConsumption) : airplane.fuelConsumption == null;
    }

    @Override
    public int hashCode() {
        int result = serialNumber != null ? serialNumber.hashCode() : 0;
        result = 31 * result + (modelName != null ? modelName.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        result = 31 * result + (flightRange != null ? flightRange.hashCode() : 0);
        result = 31 * result + (carryingCapacity != null ? carryingCapacity.hashCode() : 0);
        result = 31 * result + (maxFlightHeight != null ? maxFlightHeight.hashCode() : 0);
        result = 31 * result + (cruiseSpeed != null ? cruiseSpeed.hashCode() : 0);
        result = 31 * result + (fuelConsumption != null ? fuelConsumption.hashCode() : 0);
        return result;
    }

    @Override
    public String getDescription() {
        final StringBuilder sb = new StringBuilder(super.getDescription());
        sb.append(String.format(" | total capacity : %s ", getTotalCapacity()));
        return sb.toString();
    }
}
