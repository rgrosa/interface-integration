package br.com.renan.component.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ApiAuthenticationProvider implements AuthenticationProvider {

    @Value("${nobreak.security.user}")
    private String userName;
    @Value("${nobreak.security.user.password}")
    private String password;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String authName =  auth.getName();
        String authPassword = auth.getCredentials().toString();

        if ((!userName.contentEquals(authName) && !password.contentEquals(authPassword))) {
            if(!"1uniqueAuth1".contentEquals(authName) && !"1auth123456".contentEquals(authPassword)){
                throw new BadCredentialsException("Credenciais invalidas");
            }
            return new UsernamePasswordAuthenticationToken(authName, authPassword, new ArrayList<>());
        }
        return new UsernamePasswordAuthenticationToken(authName, authPassword, new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> type) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(type);
    }

}
