package es.boalis.security.auth.authentication;

import es.boalis.security.auth.NotFound;
import es.boalis.security.auth.authentication.exception.IncorrectPassword;
import es.boalis.security.auth.authentication.exception.PassowordExpired;
import es.boalis.security.auth.authentication.exception.PasswordProblem;
import es.boalis.security.auth.identity.Identity;

import java.util.Map;

public class AuthenticationFactory {
    Map<String,Authenticator> services;

    public void setServices(Map<String, Authenticator> services) {
        this.services = services;
    }

    public Authenticator get(String tenant, String authMethod)throws NotFound{
        if (tenant==null){
            return new Authenticator() {
                @Override
                public void authenticate(Identity id, char[] credential) throws IncorrectPassword, PassowordExpired, PasswordProblem {

                }
            };
        }else{
            Authenticator auth = services.get(tenant+"_"+services);
            if (auth==null){
                throw new NotFound("AZ:00001","Service not found");
            }else{
                return auth;
            }
        }
    }

}
