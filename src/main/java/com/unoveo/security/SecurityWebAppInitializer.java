package com.unoveo.security;

import com.unoveo.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.security.web.session.HttpSessionEventPublisher;


public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityWebAppInitializer(){
        super(WebSecurityConfig.class);
    }
    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }

}