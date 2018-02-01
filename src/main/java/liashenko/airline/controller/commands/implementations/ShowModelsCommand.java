package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.ICommand;
import liashenko.airline.service.ServiceFactory;
import liashenko.airline.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

public class ShowModelsCommand implements ICommand {
    private static final Logger logger = Logger.getLogger(ShowModelsCommand.class);

    private ServiceFactory serviceFactory;

    public ShowModelsCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        if (arr.length > 1) return "Wrong count of params";
        try {
            return serviceFactory.getMainService().showAllAvailableAirplanesModels().orElse("empty");
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "not ok";
        }
    }
}
