package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.model.service.ServiceFactory;
import liashenko.airline.model.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

//used to show the list of all available models of airplanes
public class ShowModelsCommand implements Command {
    private static final Logger logger = Logger.getLogger(ShowModelsCommand.class);

    private ServiceFactory serviceFactory;

    public ShowModelsCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        if (arr.length > 1) return "Wrong count of params";
        try {
            return serviceFactory.getMainService().showAllAvailableAirplanesModels().orElse("Data is absent");
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "We got an error";
        }
    }
}
