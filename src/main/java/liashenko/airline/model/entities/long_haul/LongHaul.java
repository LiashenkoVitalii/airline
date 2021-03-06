package liashenko.airline.model.entities.long_haul;

import liashenko.airline.model.entities.FlightHaul;

public interface LongHaul extends FlightHaul {

    HAULS HAUL_TYPE = HAULS.LONG_HAUL;
    Integer MIN_DISTANCE = 6_000;
    Integer MAX_DISTANCE = Integer.MAX_VALUE;

    default Integer validateFlightRange(Integer flightRange) {
        if (flightRange < MIN_DISTANCE || flightRange > MAX_DISTANCE) {
            throw new IllegalArgumentException("The aircraft belongs to wrong type");
        } else {
            return flightRange;
        }
    }
}
