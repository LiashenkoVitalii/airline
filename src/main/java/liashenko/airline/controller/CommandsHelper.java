package liashenko.airline.controller;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.controller.commands.implementations.*;
import liashenko.airline.model.service.ServiceFactory;
import liashenko.airline.model.service.implementation.ServiceFactoryImpl;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

//contains all available commands and keys, returns objects for their handling
public class CommandsHelper {
    public static final String EXIT_COMMAND = "exit";
    public static final String SHOW_MODELS_COMMAND = "show_models";
    public static final String ADD_COMMAND = "add";
    public static final String PRODUCER_NAME_COMMAND_KEY = "-p";
    public static final String MODEL_NAME_COMMAND_KEY = "-m";
    public static final String REMOVE_COMMAND = "rm";
    public static final String SERIAL_ID_KEY = "-serial";
    public static final String FIND_AIRCRAFT_COMMAND = "find";
    public static final String SORT_OF_AIRCRAFT_KEY = "-sort";
    public static final String SHOW_AIRLINE_AIRPLANES = "show_airplanes";
    public static final String SHOW_SORTED_AIRLINE_AIRPLANES = "show_sorted_airplanes";
    public static final String FLIGHT_RANGE_KEY = "-flight_range";
    public static final String CALCULATE_CAPACITY_COMMAND = "calculate_capacity";
    public static final String SAVE_COMMAND = "save";
    public static final String ERROR_COMMAND = "error";
    public static final String DEFAULT_COMMAND = "default";
    public static final String HELP_COMMAND = "help";
    private static final Logger logger = Logger.getLogger(CommandsHelper.class);
    private static final Map<String, Command> COMMANDS_MAP = new HashMap<>();
    public static CommandsHelper instance;
    private final ServiceFactory serviceFactory = new ServiceFactoryImpl();

    private CommandsHelper() {
        initCommandsMap(COMMANDS_MAP);

    }

    public static CommandsHelper getInstance() {
        if (instance == null) {
            instance = new CommandsHelper();
        }
        return instance;
    }

    private void initCommandsMap(Map<String, Command> commandMap) {
        commandMap.put(EXIT_COMMAND, new ExitCommand(serviceFactory));
        commandMap.put(SHOW_MODELS_COMMAND, new ShowModelsCommand(serviceFactory));
        commandMap.put(ADD_COMMAND, new AddCommand(serviceFactory));
        commandMap.put(REMOVE_COMMAND, new RemoveCommand(serviceFactory));
        commandMap.put(FIND_AIRCRAFT_COMMAND, new FindAirplaneCommand(serviceFactory));
        commandMap.put(SHOW_AIRLINE_AIRPLANES, new ListCommand(serviceFactory));
        commandMap.put(SHOW_SORTED_AIRLINE_AIRPLANES, new SortByFlightRangeCommand(serviceFactory));
        commandMap.put(CALCULATE_CAPACITY_COMMAND, new CalculateCapacityCommand(serviceFactory));
        commandMap.put(SAVE_COMMAND, new SaveCommand(serviceFactory));
        commandMap.put(ERROR_COMMAND, new ErrorCommand());
        commandMap.put(DEFAULT_COMMAND, new DefaultCommand(serviceFactory));
        commandMap.put(HELP_COMMAND, new HelpCommand());
    }

    public Command getCommand(String command) {
        return COMMANDS_MAP.containsKey(command) ? COMMANDS_MAP.get(command) : COMMANDS_MAP.get(DEFAULT_COMMAND);
    }
}
