package com.lostVictories.gameManager.bootstrap;

import com.lostVictories.gameManager.rest.GameResource;
import com.lostVictories.gameManager.rest.JoinGameResource;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;


public class JerseyResourcesModule extends JerseyServletModule {

    @Override
    protected void configureServlets() {

        bind(GameResource.class);
        bind(JoinGameResource.class);

        serve("/rest/*").with(GuiceContainer.class);
    }
}
