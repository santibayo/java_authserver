package es.boalis.security.auth.authentication.exception;

public class PassowordExpired extends Exception{
    public PassowordExpired() {
    }

    public PassowordExpired(String s) {
        super(s);
    }
}
