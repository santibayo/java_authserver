package es.boalis.security.auth.authentication.exception;

public class IncorrectPassword extends Exception{
    public IncorrectPassword() {
    }

    public IncorrectPassword(String s) {
        super(s);
    }
}
