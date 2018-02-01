package liashenko.airline.service.implementation;

import liashenko.airline.service.MainService;
import liashenko.airline.service.ServiceFactory;

public class ServiceFactoryImpl implements ServiceFactory {

    private MainService mainService;

    public ServiceFactoryImpl() {
        this.mainService = new MainServiceImpl();
    }

    public MainService getMainService() {
        return mainService;
    }
}
