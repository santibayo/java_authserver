package es.boalis.security.auth.authentication.password;

public interface PasswordTransformationService {
    public char[] transform(char[] source);
}
