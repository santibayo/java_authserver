package es.boalis.security.auth.identity;

import java.util.HashMap;
import java.util.Map;

public class Identity {
    private String username;
    private Map<String,String> attributes=new HashMap<>();

    public Identity(String username,  Map<String, String> attributes) {
        this.username = username;
        this.attributes = attributes;

    }

    public boolean isActive(){
        String active = this.attributes.get(BaseIdentityData.STATUS);
        if (active!=null){
            return active.equals(IdentityStatus.ACTIVE);
        }
        return false;

    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
