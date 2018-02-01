package liashenko.airline.model.entities.medium_haul;

import liashenko.airline.model.entities.FlightHaul;
import liashenko.airline.model.entities.long_haul.LongHaul;
import liashenko.airline.model.entities.short_haul.ShortHaul;

public interface MediumHaul extends FlightHaul {

    HAULS HAUL_TYPE = HAULS.MEDIUM_HAUL;

    Integer MIN_DISTANCE = ShortHaul.MAX_DISTANCE;
    Integer MAX_DISTANCE = LongHaul.MAX_DISTANCE;

    default Integer validateFlightRange(Integer flightRange) {
        if (flightRange < MIN_DISTANCE || flightRange > MAX_DISTANCE) {
            throw new IllegalArgumentException("The aircraft belongs to wrong type");
        } else {
            return flightRange;
        }
    }
}
