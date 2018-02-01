package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.CommandsHelper;
import liashenko.airline.controller.commands.ICommand;
import liashenko.airline.service.ServiceFactory;
import liashenko.airline.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

public class SortByFlightRangeCommand implements ICommand {
    private static final Logger logger = Logger.getLogger(SortByFlightRangeCommand.class);

    private ServiceFactory serviceFactory;

    public SortByFlightRangeCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        if (arr.length != 2) return "Wrong count of params";
        if (!CommandsHelper.FLIGHT_RANGE_KEY.equals(arr[1])) return "wrong command";
        try {
            return serviceFactory.getMainService().getAirlineAirplanesSortedByFlightRange().orElse("empty");
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "not ok";
        }
    }
}
