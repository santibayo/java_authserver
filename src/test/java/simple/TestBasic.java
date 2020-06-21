package simple;

import es.boalis.security.auth.authentication.AuthenticationFactory;
import es.boalis.security.auth.authentication.password.PasswordTransformationFactory;
import es.boalis.security.auth.identity.IdentityFactory;
import es.boalis.security.auth.identity.UsernameTransformationFactory;
import es.boalis.security.auth.services.BasicAuthenticator;
import org.junit.Test;

public class TestBasic {
    private BasicAuthenticator configure(){
        BasicAuthenticator basicAuthenticator =new BasicAuthenticator();
        basicAuthenticator.setAuthFactory(new AuthenticationFactory());
        basicAuthenticator.setIdentityFactory(new IdentityFactory());
        basicAuthenticator.setPasswordTransformationFactory(new PasswordTransformationFactory());
        basicAuthenticator.setUsernameTransformationFactory(new UsernameTransformationFactory());
        return basicAuthenticator;
    }
    @Test
    public void testSuccess()throws Exception{
        BasicAuthenticator basicAuthenticator = this.configure();
        basicAuthenticator.authenticate(null,"santi.rules","dummy123".toCharArray(),"UP",null);

    }
}
