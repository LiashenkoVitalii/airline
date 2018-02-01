package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.ICommand;
import liashenko.airline.service.ServiceFactory;
import liashenko.airline.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

public class ExitCommand implements ICommand {
    private static final Logger logger = Logger.getLogger(ExitCommand.class);

    private ServiceFactory serviceFactory;

    public ExitCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        try {
            return serviceFactory.getMainService().saveData() ? "exit" : "Couldn't save data";
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "Couldn't save data";
        }
    }
}
