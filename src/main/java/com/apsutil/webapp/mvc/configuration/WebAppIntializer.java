package com.apsutil.webapp.mvc.configuration;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { MvcConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}
	@Override
    protected Filter[] getServletFilters() {
		UrlRewriteFilter urlRewriteFilter = new UrlRewriteFilter();
		
         /* Add filter configuration here if necessary
         */
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[] {characterEncodingFilter,urlRewriteFilter,new SiteMeshFilter()};
    }
}
