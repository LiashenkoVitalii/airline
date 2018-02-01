package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.model.service.ServiceFactory;
import liashenko.airline.model.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

//used to save all changes and exit from the app
public class ExitCommand implements Command {
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
