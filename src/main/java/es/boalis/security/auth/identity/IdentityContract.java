package es.boalis.security.auth.identity;

import es.boalis.security.auth.NotFound;

public interface IdentityContract {
    public Identity getFromUserId(String uid) throws NotFound;

}
