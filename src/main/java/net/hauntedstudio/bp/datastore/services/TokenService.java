package net.hauntedstudio.bp.datastore.services;

import net.hauntedstudio.bp.datastore.utils.TokenUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    /*
    s1 = uuid
    s2 = token;
     */
    private final Map<String, String> tokenStore = new HashMap<>();

    public String generateToken(String uuid) {
        // Generate a 191-byte random array to ensure the token is 255 characters when Base64 encoded
        String token = TokenUtil.generateToken(191);
        tokenStore.put(token, uuid);
        return token;
    }

    public String validateToken(String token) {
        return tokenStore.get(token);
    }

    public void invalidateToken(String token) {
        tokenStore.remove(token);
    }

    public boolean isTokenValid(String token) {
        return tokenStore.containsKey(token);
    }


    public String getUUIDfromToken(String token) {
        return tokenStore.get(token);
    }
    public Authentication getAuthentication(String token) {
        String username = validateToken(token);
        if (username != null) {
            return new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")) // Example authority
            );
        }
        return null;
    }
}
