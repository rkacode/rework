package com.blogspot.rkacode.mvc.config;

import javax.servlet.Filter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationConfig extends AbstractAnnotationConfigDispatcherServletInitializer  {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { SecurityConfig.class };
    }
 
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { MvcConfig.class };
    }
 
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    @Override
    protected Filter[] getServletFilters() {
       return new Filter[]{new DelegatingFilterProxy("springSecurityFilterChain")};
    } 
     
}