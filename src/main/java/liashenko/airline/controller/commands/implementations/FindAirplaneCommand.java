package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.CommandsHelper;
import liashenko.airline.controller.commands.Command;
import liashenko.airline.controller.commands.Help;
import liashenko.airline.model.service.ServiceFactory;
import liashenko.airline.model.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

//used to find an aircraft by its fuel consumption degree
public class FindAirplaneCommand implements Command {
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
            return serviceFactory.getMainService().getAirlineAircraftByFuelConsumptionParam(fuelConsumption).orElse("Data is absent");
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "not ok";
        }

    }
}
