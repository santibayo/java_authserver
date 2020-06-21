package es.boalis.security.auth.identity;

import es.boalis.security.auth.NotFound;

import java.util.HashMap;
import java.util.Map;

public class IdentityFactory {
    private Map<String,IdentityContract> services;

    public void setServices(Map<String, IdentityContract> services) {
        this.services = services;
    }

    public IdentityContract get(String tenant) throws NotFound{
        if (tenant==null){
            return new IdentityContract() {
                @Override
                public Identity getFromUserId(String uid) throws NotFound {
                    Map<String,String> atts = new HashMap<>();
                    Identity id = new Identity(uid,atts);
                    return id;
                }
            };
        }else{
            IdentityContract contract = services.get(tenant);
            if (contract==null){
                throw new NotFound("IF:00001","IdentityService not found");
            }
            return contract;
        }

    }













}
