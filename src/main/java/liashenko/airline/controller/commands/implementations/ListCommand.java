package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.ICommand;
import liashenko.airline.service.ServiceFactory;
import liashenko.airline.service.exceptions.ServiceException;
import org.apache.log4j.Logger;


public class ListCommand implements ICommand {
    private static final Logger logger = Logger.getLogger(ListCommand.class);

    private ServiceFactory serviceFactory;

    public ListCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        if (arr.length > 1) return "Wrong count of params";
        try {
            return serviceFactory.getMainService().getAirlineAirplanesList().orElse("empty");
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "not ok";
        }
    }
}
