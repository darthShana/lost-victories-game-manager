package com.lostVictories.gameManager.bootstrap;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import io.ebean.EbeanServer;

import javax.sql.DataSource;

public class ServicesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DataSource.class).toProvider(H2DataSourceProvider.class).in(Scopes.SINGLETON);
        bind(EbeanServer.class).toProvider(EbeanServerProvider.class).asEagerSingleton();

    }
}
