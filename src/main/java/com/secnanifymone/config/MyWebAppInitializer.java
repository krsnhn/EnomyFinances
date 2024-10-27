package com.secnanifymone.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.context.ContextLoaderListener; // Import ContextLoaderListener

public class MyWebAppInitializer implements WebApplicationInitializer {

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//		appContext.register(WebConfig.class);
//
//		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
//		new DispatcherServlet(appContext));
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/"); // Handle all requests
//	}
//}
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        // Create the root WebApplicationContext
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfig.class);
 
        // Manage the lifecycle of the root WebApplicationContext
        servletContext.addListener(new ContextLoaderListener(rootContext));
        
        // Create the dispatcher servlet's WebApplicationContext
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebConfig.class);
        
        // Register and configure the DispatcherServlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
