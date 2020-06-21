package es.boalis.security.auth.identity;

import es.boalis.security.auth.NotFound;

import java.util.Map;

public class UsernameTransformationFactory {
    Map<String,UsernameTransformationService> services;

    public void setServices(Map<String, UsernameTransformationService> services) {
        this.services = services;
    }

    public UsernameTransformationService get(String tenant)throws NotFound{
        if (services == null) {
            return sourceUsername -> sourceUsername;
        }else{
            UsernameTransformationService service = services.get(tenant);
            if (service==null){
                throw new NotFound("TN:00001","Service not found for tenant");
            }
            return service;
        }
    }
}
