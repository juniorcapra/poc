package com.example.webflux.configuration;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.example.webflux.dao")
public class PostgresConfig extends AbstractR2dbcConfiguration {

    @Value("${postgres.host}")
    private String host;

    @Value("${postgres.port}")
    private String port;

    @Value("${postgres.database}")
    private String database;

    @Value("${postgres.schema}")
    private String schema;

    @Value("${postgres.username}")
    private String username;

    @Value("${postgres.password}")
    private String password;

    @Bean
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host(host)
                        .port(Integer.valueOf(port))
                        .database(database)
                        .schema(schema)
                        .username(username)
                        .password(password)
                        .build()
        );
    }
}
