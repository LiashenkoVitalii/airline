package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.CommandsHelper;
import liashenko.airline.controller.commands.Help;
import liashenko.airline.controller.commands.ICommand;
import liashenko.airline.service.ServiceFactory;
import liashenko.airline.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

public class FindAirplaneCommand implements ICommand {
    private static final Logger logger = Logger.getLogger(FindAirplaneCommand.class);

    private ServiceFactory serviceFactory;

    public FindAirplaneCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        if (arr.length != 3) return "Wrong count of params";
        String idStr = Help.getValueByKey(arr, CommandsHelper.SORT_OF_AIRCRAFT_KEY);
        try {
            Integer fuelConsumption = Integer.valueOf(idStr);
            return serviceFactory.getMainService().getAirlineAircraftByFuelConsumptionParam(fuelConsumption).orElse("empty");
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "not ok";
        }

    }
}
