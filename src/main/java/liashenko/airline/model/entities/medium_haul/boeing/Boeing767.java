package liashenko.airline.model.entities.medium_haul.boeing;

import liashenko.airline.model.entities.medium_haul.MediumHaul;
import liashenko.airline.model.entities.producers.Boeing;

public class Boeing767 extends Boeing implements MediumHaul {
    private static final long serialVersionUID = 1L;

    private Integer firstClassCapacity = 134;
    private Integer economClassCapacity = 95;

    public Boeing767() {
        this.modelName = "Boeing-767";
        this.flightRange = validateFlightRange(4_000);
        this.carryingCapacity = 47_000;
        this.maxFlightHeight = 10_668;
        this.cruiseSpeed = 873;
        this.fuelConsumption = 4_550;
        this.haulType = HAULS.MEDIUM_HAUL;
    }

    @Override
    public Integer getTotalCapacity() {
        return economClassCapacity + firstClassCapacity;
    }

    public Integer getFirstClassCapacity() {
        return firstClassCapacity;
    }

    public Integer getEconomClassCapacity() {
        return economClassCapacity;
    }

    @Override
    public Boeing767 clone() throws CloneNotSupportedException {
        return (Boeing767) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boeing767)) return false;

        Boeing767 boeing767 = (Boeing767) o;

        if (firstClassCapacity != null ? !firstClassCapacity.equals(boeing767.firstClassCapacity) : boeing767.firstClassCapacity != null)
            return false;
        return economClassCapacity != null ? economClassCapacity.equals(boeing767.economClassCapacity) : boeing767.economClassCapacity == null;
    }

    @Override
    public int hashCode() {
        int result = firstClassCapacity != null ? firstClassCapacity.hashCode() : 0;
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
