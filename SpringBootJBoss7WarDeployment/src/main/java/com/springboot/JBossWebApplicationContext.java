package com.springboot;

import java.lang.reflect.Field;
import java.util.Collection;

import javax.servlet.Filter;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

public class JBossWebApplicationContext extends AnnotationConfigServletWebServerApplicationContext {
	protected Collection<ServletContextInitializer> getServletContextInitializerBeans() {
		Collection<ServletContextInitializer> servletContextInitializerBeans = super.getServletContextInitializerBeans();
		for (ServletContextInitializer servletContextInitializerBean : servletContextInitializerBeans) {
			if (servletContextInitializerBean instanceof FilterRegistrationBean) {
				FilterRegistrationBean frb = (FilterRegistrationBean) servletContextInitializerBean;
				try {
					Field field = FilterRegistrationBean.class.getDeclaredField("filter");
					field.setAccessible(true);
					Filter origFilter = (Filter) field.get(frb);
					frb.setFilter(new DelegatingFilterProxy(origFilter));
				} catch (NoSuchFieldException | IllegalAccessException e) {
					throw new BeanCreationException("Error setting up bean. It does not have a filter field", e);
				}
			}
		}

		return servletContextInitializerBeans;
	}
}