package liashenko.airline.entities.short_haul.tu;

import liashenko.airline.entities.producers.Tu;
import liashenko.airline.entities.short_haul.ShortHaul;

public class Tu134 extends Tu implements ShortHaul {
    private static final long serialVersionUID = 1L;

    private Integer businessClassCapacity = 76;
    private Integer economClassCapacity = 68;

    public Tu134() {
        this.modelName = "Tu-134";
        this.flightRange = validateFlightRange(1_000);
        this.carryingCapacity = 14_000;
        this.maxFlightHeight = 11_000;
        this.cruiseSpeed = 850;
        this.fuelConsumption = 2_500;
    }

    public Integer getBusinessClassCapacity() {
        return businessClassCapacity;
    }

    public Integer getEconomClassCapacity() {
        return economClassCapacity;
    }

    @Override
    public Integer getTotalCapacity() {
        return economClassCapacity + businessClassCapacity;
    }

    @Override
    public Tu134 clone() throws CloneNotSupportedException {
        return (Tu134) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tu134)) return false;

        Tu134 tu134 = (Tu134) o;

        if (businessClassCapacity != null ? !businessClassCapacity.equals(tu134.businessClassCapacity) : tu134.businessClassCapacity != null)
            return false;
        return economClassCapacity != null ? economClassCapacity.equals(tu134.economClassCapacity) : tu134.economClassCapacity == null;
    }

    @Override
    public int hashCode() {
        int result = businessClassCapacity != null ? businessClassCapacity.hashCode() : 0;
        result = 31 * result + (economClassCapacity != null ? economClassCapacity.hashCode() : 0);
        return result;
    }

    @Override
    public String getDescription() {
        final StringBuilder sb = new StringBuilder(super.getDescription());
        sb.append(String.format(" | total capacity : %s (business class  : %s, econom class : %s)",
                getTotalCapacity(), businessClassCapacity, economClassCapacity));
        return sb.toString();
    }
}
