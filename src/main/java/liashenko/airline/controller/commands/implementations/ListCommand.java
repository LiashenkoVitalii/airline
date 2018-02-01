package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.model.service.ServiceFactory;
import liashenko.airline.model.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

//used to print the list of all airplanes from the airline park
public class ListCommand implements Command {
    private static final Logger logger = Logger.getLogger(ListCommand.class);

    private ServiceFactory serviceFactory;

    public ListCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        if (arr.length > 1) return "Wrong count of params";
        try {
            return serviceFactory.getMainService().getAirlineAirplanesList().orElse("Data is absent");
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "We got an error";
        }
    }
}
