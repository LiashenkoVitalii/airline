package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.ICommand;
import liashenko.airline.service.ServiceFactory;
import org.apache.log4j.Logger;

public class DefaultCommand implements ICommand {
    private static final Logger logger = Logger.getLogger(DefaultCommand.class);

    private ServiceFactory serviceFactory;

    public DefaultCommand(ServiceFactory serviceFactory) {
//        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        return "this command doesn't exist";
    }
}
