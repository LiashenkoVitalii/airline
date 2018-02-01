package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.CommandsHelper;
import liashenko.airline.controller.commands.Help;
import liashenko.airline.controller.commands.ICommand;
import liashenko.airline.service.ServiceFactory;
import liashenko.airline.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

public class RemoveCommand implements ICommand {
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
            return serviceFactory.getMainService().removeAirplaneFromAirlineFleet(airplaneSerialNum) ? "ok" : "not ok";
        } catch (ServiceException | NumberFormatException ex) {
            logger.error(ex.getMessage());
            return "not ok";
        }
    }
}
