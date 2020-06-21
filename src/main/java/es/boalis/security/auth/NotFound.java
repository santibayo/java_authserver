package es.boalis.security.auth;

public class NotFound extends Exception{
    private String description;
    public NotFound() {
    }

    public NotFound(String s,String description) {
        super(s);
        this.description = description;
    }
}
