package es.boalis.security.auth.authentication.password;

import es.boalis.security.auth.NotFound;

import java.util.Map;

public class PasswordTransformationFactory {
    private Map<String,PasswordTransformationService> services;
    public PasswordTransformationService get(String tenant)throws NotFound {
        if (tenant==null) {
            return new PasswordTransformationService() {
                @Override
                public char[] transform(char[] source) {
                    return source;
                }
            };
        }else{
            PasswordTransformationService passwordTransformationService = services.get(tenant);
            if (passwordTransformationService==null){
                throw new NotFound("PT:00001","Password Transformation service not found");
            }
            return passwordTransformationService;
        }

    }
}
