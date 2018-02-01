package liashenko.airline.model.service;

//provides opportunity to work with different service implementations
public interface ServiceFactory {
    MainService getMainService();
}
