package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.model.service.ServiceFactory;
import liashenko.airline.model.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

//used to save changes on the users hard drive
public class SaveCommand implements Command {
    private static final Logger logger = Logger.getLogger(SaveCommand.class);

    private ServiceFactory serviceFactory;

    public SaveCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        if (arr.length > 1) return "Wrong count of params";
        try {
            return serviceFactory.getMainService().saveData() ? "Data saved" : "Couldn't save data";
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "We got an error. Couldn't save data";
        }
    }
}
