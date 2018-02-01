package liashenko.airline.model.service.implementation;

import liashenko.airline.model.persistence.storage.PersistenceFactoryImpl;
import liashenko.airline.model.service.MainService;
import liashenko.airline.model.service.ServiceFactory;

public class ServiceFactoryImpl implements ServiceFactory {

    private MainService mainService;

    public ServiceFactoryImpl() {
        this.mainService = new MainServiceImpl(new PersistenceFactoryImpl());
    }

    public MainService getMainService() {
        return mainService;
    }
}
