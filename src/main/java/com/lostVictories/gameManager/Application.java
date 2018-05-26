package com.lostVictories.gameManager;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.lostVictories.gameManager.bootstrap.DIServletContextListener;

import com.lostVictories.gameManager.bootstrap.JerseyResourcesModule;
import com.lostVictories.gameManager.bootstrap.ServicesModule;
import com.lostVictories.gameManager.security.CreateUserServlet;
import com.lostVictories.gameManager.service.GameLoginService;
import com.lostVictories.gameManager.security.LoginServlet;
import org.eclipse.jetty.security.*;
import org.eclipse.jetty.security.authentication.FormAuthenticator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.security.Constraint;


import java.io.FileInputStream;
import java.util.EnumSet;
import java.util.Properties;

public class Application {

    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        if ((args != null) && (args.length > 0)) {
            p.load(new FileInputStream(args[0]));
        } else {
            p.load(new FileInputStream("src/test/resources/application.properties"));
        }
        p.stringPropertyNames().forEach(pn -> System.setProperty(pn, p.getProperty(pn)));


        Server jettyServer = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(jettyServer, "/*", ServletContextHandler.SESSIONS);

        Injector injector = Guice.createInjector(new ServicesModule(), new JerseyResourcesModule());
        context.addEventListener(new DIServletContextListener(injector));
        context.addFilter(GuiceFilter.class, "/rest/*", EnumSet.of(javax.servlet.DispatcherType.REQUEST, javax.servlet.DispatcherType.ASYNC));

//        context.addServlet(new ServletHolder(injector.getInstance(LoginServlet.class)), "/login");
//        context.addServlet(new ServletHolder(injector.getInstance(CreateUserServlet.class)), "/createUser");
//
//        Constraint constraint = new Constraint();
//        constraint.setName(Constraint.__FORM_AUTH);
//        constraint.setRoles(new String[]{"user"});
//        constraint.setAuthenticate(true);
//
//        ConstraintMapping constraintMapping = new ConstraintMapping();
//        constraintMapping.setConstraint(constraint);
//        constraintMapping.setPathSpec("/rest/*");
//
//        ConstraintSecurityHandler securityHandler = new ConstraintSecurityHandler();
//        securityHandler.addConstraintMapping(constraintMapping);
//
//        securityHandler.setLoginService(injector.getInstance(GameLoginService.class));
//
//        FormAuthenticator authenticator = new FormAuthenticator("/login", "/login", false);
//        securityHandler.setAuthenticator(authenticator);
//
//        context.setSecurityHandler(securityHandler);

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }




    }
}
