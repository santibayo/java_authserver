package es.boalis.security.auth.services;

import es.boalis.security.auth.NotFound;
import es.boalis.security.auth.authentication.*;
import es.boalis.security.auth.authentication.exception.IncorrectPassword;
import es.boalis.security.auth.authentication.exception.PassowordExpired;
import es.boalis.security.auth.authentication.exception.PasswordProblem;

import es.boalis.security.auth.authentication.password.PasswordTransformationFactory;
import es.boalis.security.auth.identity.*;

public class BasicAuthenticator {
    private UsernameTransformationFactory usernameTransformationFactory;
    private AuthenticationFactory authFactory;
    private IdentityFactory identityFactory;
    private PasswordTransformationFactory passwordTransformationFactory;

    public AuthenticationFactory getAuthFactory() {
        return authFactory;
    }

    public void setAuthFactory(AuthenticationFactory authFactory) {
        this.authFactory = authFactory;
    }

    public void setIdentityFactory(IdentityFactory identityFactory) {
        this.identityFactory = identityFactory;
    }

    public void setPasswordTransformationFactory(PasswordTransformationFactory passwordTransformationFactory) {
        this.passwordTransformationFactory = passwordTransformationFactory;
    }

    public void setUsernameTransformationFactory(UsernameTransformationFactory usernameTransformationFactory) {
        this.usernameTransformationFactory = usernameTransformationFactory;
    }

    public Identity authenticate(String tenant, String givenUsername, char[] credential, String authMethod, Identity identity) throws NotFound, IncorrectPassword, PassowordExpired, PasswordProblem {
        Identity userIdentityData = null;
        if (identity==null) {
            String transformedUsername = usernameTransformationFactory.
                    get(tenant).
                    transformUsername(givenUsername);
            if (transformedUsername==null){
                throw new NotFound("RV:00010","username transformation throw an exception");
            }
            userIdentityData = identityFactory.
                    get(tenant).
                    getFromUserId(transformedUsername);
            if (userIdentityData == null) {
                throw new NotFound("CD:00012", "Identity data not found");
            }
        }else{
            userIdentityData = identity;
        }


        Authenticator authenticator = authFactory.get(tenant,authMethod);
        if (authenticator != null) {
            char [] transformedCredential = passwordTransformationFactory.
                    get(tenant).
                    transform(credential);
            authenticator.authenticate(userIdentityData,transformedCredential);
            return userIdentityData;
        }
        throw new NotFound("AU:00001","Authmethod not found");
    }
}
