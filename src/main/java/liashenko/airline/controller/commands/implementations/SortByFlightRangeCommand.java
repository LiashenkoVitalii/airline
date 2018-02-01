package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.CommandsHelper;
import liashenko.airline.controller.commands.Command;
import liashenko.airline.model.service.ServiceFactory;
import liashenko.airline.model.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

//used to sort all airplanes from the airline park by flight range
public class SortByFlightRangeCommand implements Command {
    private static final Logger logger = Logger.getLogger(SortByFlightRangeCommand.class);

    private ServiceFactory serviceFactory;

    public SortByFlightRangeCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        if (arr.length != 2) return "Wrong count of params";
        if (!CommandsHelper.FLIGHT_RANGE_KEY.equals(arr[1])) return "Wrong command";
        try {
            return serviceFactory.getMainService().getAirlineAirplanesSortedByFlightRange().orElse("Data is absent");
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "We got an error";
        }
    }
}
