package liashenko.airline.controller.commands;

import liashenko.airline.controller.CommandsHelper;


//contains all available commands
public abstract class Help {

    private final static String EXIT_COM = String.format("type \"%s\" to quit from the application",
            CommandsHelper.EXIT_COMMAND);

    private final static String SHOW_AVAILABLE_AIRCRAFT_MODELS_COM = String.format("type \"%s\" to get list of " +
            "available airplane models", CommandsHelper.SHOW_MODELS_COMMAND);

    private final static String ADD_COM = String.format("type \"%s %s airplane_producer_name %s airplane_model_name\" " +
                    "to add it to the airline park (use underscores instead of spaces)", CommandsHelper.ADD_COMMAND, CommandsHelper.PRODUCER_NAME_COMMAND_KEY,
            CommandsHelper.MODEL_NAME_COMMAND_KEY);

    private final static String REMOVE_COM = String.format("type \"%s %s airplane_serial_number_id\" to remove it " +
            "to the airline park", CommandsHelper.REMOVE_COMMAND, CommandsHelper.SERIAL_ID_KEY);

    private final static String FIND_AIRCRAFT_BY_FUEL_CONSUMT_PARAM_COM = String.format("type \"%s  %s " +
                    "fuel_consumption_degree\" to find the airplane in the airline park by fuel consumption degree",
            CommandsHelper.FIND_AIRCRAFT_COMMAND, CommandsHelper.SORT_OF_AIRCRAFT_KEY);

    private final static String LIST_COM = String.format("type \"%s\" to see the airline park",
            CommandsHelper.SHOW_AIRLINE_AIRPLANES);

    private final static String SORT_AIRCRAFT_BY_FLIGHT_RANGE_COM = String.format("type \"%s %s\" to see the airline park " +
            "sorted by flight range", CommandsHelper.SHOW_SORTED_AIRLINE_AIRPLANES, CommandsHelper.FLIGHT_RANGE_KEY);

    private final static String CALCULATE_TOTAL_AND_CARRYING_CAPACITY = String.format("type \"%s\" to calculate " +
            "total and carrying capacity of all airplanes in the airline park", CommandsHelper.CALCULATE_CAPACITY_COMMAND);

    private final static String SAVE = String.format("type \"%s\" to save info on the hard drive", CommandsHelper.SAVE_COMMAND);

    public final static String[] COMMANDS_LIST = {
            EXIT_COM,
            SHOW_AVAILABLE_AIRCRAFT_MODELS_COM,
            ADD_COM,
            REMOVE_COM,
            FIND_AIRCRAFT_BY_FUEL_CONSUMT_PARAM_COM,
            LIST_COM,
            SORT_AIRCRAFT_BY_FLIGHT_RANGE_COM,
            CALCULATE_TOTAL_AND_CARRYING_CAPACITY,
            SAVE
    };

    public static String getValueByKey(String[] commandsArr, String key) {
        String value = "";
        for (int commandsCounter = 0; commandsCounter < commandsArr.length; commandsCounter++) {
            if (commandsArr[commandsCounter].isEmpty()) continue;

            if (commandsArr[commandsCounter].equals(key) && commandsCounter < (commandsArr.length - 1)) {
                if (!commandsArr[commandsCounter + 1].isEmpty()) {
                    value = commandsArr[commandsCounter + 1];
                    break;
                }
            }
        }
        return value.replace('_', ' ');
    }
}
