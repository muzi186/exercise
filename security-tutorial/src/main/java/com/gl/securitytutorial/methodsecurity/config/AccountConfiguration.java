package com.gl.securitytutorial.methodsecurity.config;

import com.gl.securitytutorial.methodsecurity.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin on 16-6-2.
 */
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class AccountConfiguration {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
//    }

    @Bean
    public AuthenticationManager getAuthenticationManager(){
        List<AuthenticationProvider> providers = new ArrayList<>();
        providers.add(new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                if(authentication == null){
                    throw new BadCredentialsException("Bad credentials");
                }

                if(authentication.getPrincipal() == null){
                    throw new BadCredentialsException("bad principal");
                }


                if(!authentication.getPrincipal().equals(authentication.getCredentials())){
                    throw new BadCredentialsException("bad credentials");
                }

                Object principal = authentication.getPrincipal();
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

                if(principal.equals("user-test")){
                    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                }else if(principal.equals("admin-test")){
                    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                    authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                }else if(principal.equals("supervisor-test")){
                    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                    authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    authorities.add(new SimpleGrantedAuthority("ROLE_SUPERVISOR"));
                }else{
                    //do nothing
                }

                Authentication auth = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
                        authentication.getCredentials(),authorities);

                return auth;
            }

            @Override
            public boolean supports(Class<?> authentication) {
                return true;
            }
        });


        AuthenticationManager manager = new ProviderManager(providers);

        return manager;
    }

    @Bean
    public AccountService getAccountService(){
        return new AccountService();
    }
}
