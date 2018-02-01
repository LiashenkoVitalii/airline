package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.model.service.ServiceFactory;
import liashenko.airline.model.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

//used to return result of calculations of total capacity and carrying capacity of the airline park
public class CalculateCapacityCommand implements Command {
    private static final Logger logger = Logger.getLogger(CalculateCapacityCommand.class);

    private ServiceFactory serviceFactory;

    public CalculateCapacityCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        if (arr.length > 1) return "Wrong count of params";
        try {
            return serviceFactory.getMainService().calculateCapacity().orElse("Data is absent");
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "Something bad happened";
        }
    }
}
