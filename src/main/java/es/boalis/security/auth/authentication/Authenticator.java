package es.boalis.security.auth.authentication;

import es.boalis.security.auth.authentication.exception.IncorrectPassword;
import es.boalis.security.auth.authentication.exception.PassowordExpired;
import es.boalis.security.auth.authentication.exception.PasswordProblem;
import es.boalis.security.auth.identity.Identity;

public interface Authenticator {
    public void authenticate(Identity id, char[] credential)throws IncorrectPassword, PassowordExpired, PasswordProblem;
}
