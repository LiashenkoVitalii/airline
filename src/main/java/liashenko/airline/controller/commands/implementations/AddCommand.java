package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.CommandsHelper;
import liashenko.airline.controller.commands.Help;
import liashenko.airline.controller.commands.ICommand;
import liashenko.airline.service.ServiceFactory;
import liashenko.airline.service.exceptions.ServiceException;
import org.apache.log4j.Logger;

public class AddCommand implements ICommand {
    private static final Logger logger = Logger.getLogger(AddCommand.class);

    private ServiceFactory serviceFactory;

    public AddCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        if (arr.length != 5) return "Wrong count of params";
        String producer = Help.getValueByKey(arr, CommandsHelper.PRODUCER_NAME_COMMAND_KEY);
        String model = Help.getValueByKey(arr, CommandsHelper.MODEL_NAME_COMMAND_KEY);
        try {
            return (serviceFactory.getMainService().addNewAirplaneToAirlineFleet(producer, model)) ? "ok" : "not ok";
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            return "not ok";
        }
    }
}
