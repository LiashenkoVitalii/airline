package liashenko.airline.entities.medium_haul.airbus;

import liashenko.airline.entities.medium_haul.MediumHaul;
import liashenko.airline.entities.producers.AirBus;

public class AirBusA320_200 extends AirBus implements MediumHaul {

    private static final long serialVersionUID = 1L;

    public AirBusA320_200() {
        this.modelName = "A-320-200";
        this.flightRange = validateFlightRange(3_717);
        this.carryingCapacity = 73_500;
        this.maxFlightHeight = 10_668;
        this.cruiseSpeed = 853;
        this.fuelConsumption = 2_040;
    }

    @Override
    public Integer getTotalCapacity() {
        return 150;
    }

    @Override
    public AirBusA320_200 clone() throws CloneNotSupportedException {
        return (AirBusA320_200) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirBusA320_200)) return false;

        AirBusA320_200 airplane = (AirBusA320_200) o;

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
