package com.nichoudhary.soap.webservices.soapcoursemanagement.soap;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;


//Enable Spring Web Services
// Spring Configuration
@EnableWs
@Configuration
public class WebServiceConfig {

    //Message Dispatcher Servlet
        //Application Context
        // uri -> /ws/*

    @Bean
    ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        // Map message dispatcher servlet to this url "/ws/*"
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

}
