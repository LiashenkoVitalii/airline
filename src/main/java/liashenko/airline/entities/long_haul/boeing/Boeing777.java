package liashenko.airline.entities.long_haul.boeing;

import liashenko.airline.entities.long_haul.LongHaul;
import liashenko.airline.entities.producers.Boeing;

public class Boeing777 extends Boeing implements LongHaul {
    private static final long serialVersionUID = 1L;

    private Integer firstClassCapacity = 17;
    private Integer businessClassCapacity = 70;
    private Integer economClassCapacity = 148;

    public Boeing777() {
        this.modelName = "Boeing-777";
        this.flightRange = validateFlightRange(7_406);
        this.carryingCapacity = 51_250;
        this.maxFlightHeight = 10_668;
        this.cruiseSpeed = 891;
        this.fuelConsumption = 6_100;
    }

    @Override
    public Integer getTotalCapacity() {
        return firstClassCapacity + businessClassCapacity + economClassCapacity;
    }

    public Integer getFirstClassCapacity() {
        return firstClassCapacity;
    }

    public Integer getBusinessClassCapacity() {
        return businessClassCapacity;
    }

    public Integer getEconomClassCapacity() {
        return economClassCapacity;
    }

    @Override
    public Boeing777 clone() throws CloneNotSupportedException {
        return (Boeing777) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boeing777)) return false;

        Boeing777 boeing777 = (Boeing777) o;

        if (firstClassCapacity != null ? !firstClassCapacity.equals(boeing777.firstClassCapacity) : boeing777.firstClassCapacity != null)
            return false;
        if (businessClassCapacity != null ? !businessClassCapacity.equals(boeing777.businessClassCapacity) : boeing777.businessClassCapacity != null)
            return false;
        return economClassCapacity != null ? economClassCapacity.equals(boeing777.economClassCapacity) : boeing777.economClassCapacity == null;
    }

    @Override
    public int hashCode() {
        int result = firstClassCapacity != null ? firstClassCapacity.hashCode() : 0;
        result = 31 * result + (businessClassCapacity != null ? businessClassCapacity.hashCode() : 0);
        result = 31 * result + (economClassCapacity != null ? economClassCapacity.hashCode() : 0);
        return result;
    }

    @Override
    public String getDescription() {
        final StringBuilder sb = new StringBuilder(super.getDescription());
        sb.append(String.format(" | total capacity : %s (first class  : %s, econom class : %s)",
                getTotalCapacity(), firstClassCapacity, economClassCapacity));
        return sb.toString();
    }
}
