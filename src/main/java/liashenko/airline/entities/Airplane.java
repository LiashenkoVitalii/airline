package liashenko.airline.entities;

import java.io.Serializable;

public abstract class Airplane implements FlightHaul, Serializable, Cloneable {

    protected Long serialNumber;
    protected String modelName;
    protected String producer;
    protected Integer flightRange;
    protected Integer carryingCapacity;
    protected Integer maxFlightHeight;
    protected Integer cruiseSpeed;
    protected Integer fuelConsumption;

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public Integer getFlightRange() {
        return flightRange;
    }

    public abstract Integer getTotalCapacity();

    public Integer getCarryingCapacity() {
        return carryingCapacity;
    }

    public Integer getMaxFlightHeight() {
        return maxFlightHeight;
    }

    public Integer getCruiseSpeed() {
        return cruiseSpeed;
    }

    public String getProducer() {
        return producer;
    }

    public Integer getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public Airplane clone() throws CloneNotSupportedException {
        return (Airplane) super.clone();
    }

    public String getDescription(){
            final StringBuilder sb = new StringBuilder();
            sb.append(String.format("| model name : %-15s", modelName));
            if (serialNumber != null) {
                sb.append(String.format(" | serial № : %-5s", serialNumber));
            }
            sb.append(String.format(" | producer : %-25s", producer));
            sb.append(String.format(" | flight range : %-5s km", flightRange));
            sb.append(String.format(" | carrying capacity : %-7s kg", carryingCapacity));
            sb.append(String.format(" | max flight height : %-7s m", maxFlightHeight));
            sb.append(String.format(" | cruise speed : %-4s km/h", cruiseSpeed));
            sb.append(String.format(" | fuel consumption : %-5s l/h", fuelConsumption));
            return sb.toString();
    }
}
