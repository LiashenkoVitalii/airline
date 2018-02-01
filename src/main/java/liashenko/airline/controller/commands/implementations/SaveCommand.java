package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.ICommand;
import liashenko.airline.service.ServiceFactory;
import liashenko.airline.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

public class SaveCommand implements ICommand {
    private static final Logger logger = Logger.getLogger(SaveCommand.class);

    private ServiceFactory serviceFactory;

    public SaveCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        if (arr.length > 1) return "Wrong count of params";
        try {
            return serviceFactory.getMainService().saveData() ? "ok" : "not ok";
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "not ok";
        }
    }
}
