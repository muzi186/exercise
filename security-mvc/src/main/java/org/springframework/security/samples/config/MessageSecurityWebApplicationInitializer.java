package org.springframework.security.samples.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by gavin on 16-6-1.
 */
public class MessageSecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfiguration.class };
    }

}
