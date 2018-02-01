package liashenko.airline.model.entities.short_haul;

import liashenko.airline.model.entities.FlightHaul;

public interface ShortHaul extends FlightHaul {

    HAULS HAUL_TYPE = HAULS.SHORT_HAUL;

    Integer MIN_DISTANCE = 0;
    Integer MAX_DISTANCE = 2_500;

    default Integer validateFlightRange(Integer flightRange) {
        if (flightRange < MIN_DISTANCE || flightRange > MAX_DISTANCE) {
            throw new IllegalArgumentException("The aircraft belongs to wrong type");
        } else {
            return flightRange;
        }
    }
}
