package com.lostVictories.gameManager.bootstrap;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;


public class DIServletContextListener extends GuiceServletContextListener {
    private Injector injector;

    public DIServletContextListener(Injector injector) {
        this.injector = injector;
    }

    @Override
    protected Injector getInjector() {
        return injector;

    }
}
