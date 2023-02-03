package com.example.demo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.relational.core.dialect.MariaDbDialect;
import org.springframework.r2dbc.core.DatabaseClient;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
public class DBConfig extends AbstractR2dbcConfiguration {

    @Bean
    @Override
    public ConnectionFactory connectionFactory() {

        ConnectionFactory connection = ConnectionFactories.get(
                ConnectionFactoryOptions.builder()
                        .option(DRIVER, "mariadb")
                        .option(HOST, "localhost")
                        .option(PORT, 3306)
                        .option(USER, "root")
                        .option(PASSWORD, "mariadb")
                        .option(DATABASE, "r2dbc_sample")
                        .build()
        );

        return connection;
    }

    @Bean
    public R2dbcEntityTemplate template(@Autowired ConnectionFactory factory){

        return new R2dbcEntityTemplate(factory);
    }



}
