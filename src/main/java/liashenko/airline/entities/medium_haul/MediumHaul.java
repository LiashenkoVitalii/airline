package liashenko.airline.entities.medium_haul;

import liashenko.airline.entities.FlightHaul;
import liashenko.airline.entities.long_haul.LongHaul;
import liashenko.airline.entities.short_haul.ShortHaul;

public interface MediumHaul extends FlightHaul {

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
