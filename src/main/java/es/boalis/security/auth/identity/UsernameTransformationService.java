package es.boalis.security.auth.identity;

public interface UsernameTransformationService {
    public String transformUsername(String sourceUsername);
}
