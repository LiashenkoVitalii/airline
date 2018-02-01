package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.CommandsHelper;
import liashenko.airline.controller.commands.Command;
import liashenko.airline.controller.commands.Help;
import liashenko.airline.model.service.ServiceFactory;
import liashenko.airline.model.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

//used to remove the airplane from the airline park
public class RemoveCommand implements Command {
    private static final Logger logger = Logger.getLogger(RemoveCommand.class);

    private ServiceFactory serviceFactory;

    public RemoveCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        if (arr.length != 3) return "Wrong count of params";
        String idStr = Help.getValueByKey(arr, CommandsHelper.SERIAL_ID_KEY);
        try {
            Long airplaneSerialNum = Long.valueOf(idStr);
            return serviceFactory.getMainService().removeAirplaneFromAirlineFleet(airplaneSerialNum)
                    ? "The airplane have been removed" : "The airplane can not be removed";
        } catch (ServiceException | NumberFormatException ex) {
            logger.error(ex.getMessage());
            return "We got an error";
        }
    }
}
