package liashenko.airline.controller.commands.implementations;

import liashenko.airline.controller.commands.Command;
import liashenko.airline.model.service.ServiceFactory;
import org.apache.log4j.Logger;

//used to be executed if user entered non-existing command
public class DefaultCommand implements Command {
    private static final Logger logger = Logger.getLogger(DefaultCommand.class);

    private ServiceFactory serviceFactory;

    public DefaultCommand(ServiceFactory serviceFactory) {
//        this.serviceFactory = serviceFactory;
    }

    @Override
    public String handle(String[] arr) {
        return "This command doesn't exist";
    }
}
