package liashenko.airline.model.entities;

//used to validate airplanes and divide them to three groups (short haul, medium haul, long haul)
public interface FlightHaul {

    Integer validateFlightRange(Integer flightRange);

    enum HAULS {
        SHORT_HAUL("short haul"),
        MEDIUM_HAUL("medium haul"),
        LONG_HAUL("long haul");

        private String type;

        HAULS(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return this.type;
        }
    }
}
