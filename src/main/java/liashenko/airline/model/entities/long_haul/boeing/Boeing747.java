package liashenko.airline.model.entities.long_haul.boeing;

import liashenko.airline.model.entities.long_haul.LongHaul;
import liashenko.airline.model.entities.producers.Boeing;

public class Boeing747 extends Boeing implements LongHaul {

    private static final long serialVersionUID = 1L;

    public Boeing747() {
        this.modelName = "Boeing-747-200";
        this.flightRange = validateFlightRange(9_850);
        this.carryingCapacity = 67_360;
        this.maxFlightHeight = 10_668;
        this.cruiseSpeed = 917;
        this.fuelConsumption = 13_500;
        this.haulType = HAULS.LONG_HAUL;
    }

    @Override
    public Integer getTotalCapacity() {
        return 423;
    }

    @Override
    public Boeing747 clone() throws CloneNotSupportedException {
        return (Boeing747) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boeing747)) return false;

        Boeing747 airplane = (Boeing747) o;

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
        sb.append(String.format(" | total capacity : %s", getTotalCapacity()));
        return sb.toString();
    }
}
