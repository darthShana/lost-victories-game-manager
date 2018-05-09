package com.lostVictories.gameManager.bootstrap;

import com.lostVictories.gameManager.core.ConfigEnum;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.inject.Provider;
import javax.sql.DataSource;

public class H2DataSourceProvider implements Provider<DataSource>{

    @Override
    public DataSource get() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(ConfigEnum.DATABASE_URL.get());
        config.setUsername(ConfigEnum.DATABASE_USERNAME.get());
        config.setPassword(ConfigEnum.DATABASE_PASSWORD.get());
        config.addDataSourceProperty("useSSL", "false");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }
}
