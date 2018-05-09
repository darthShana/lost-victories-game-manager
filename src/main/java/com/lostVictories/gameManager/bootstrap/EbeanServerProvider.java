package com.lostVictories.gameManager.bootstrap;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.flywaydb.core.Flyway;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.sql.DataSource;

public class EbeanServerProvider implements Provider<EbeanServer>{

    @Inject
    DataSource dataSource;

    @Override
    public EbeanServer get() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.migrate();

        ServerConfig config = new ServerConfig();
        config.setDataSource(dataSource);
        return EbeanServerFactory.create(config);
    }
}
