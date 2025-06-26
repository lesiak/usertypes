package com.lesiak.test.usertypes.repository;

import javax.sql.DataSource;

import java.io.IOException;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.lesiak.test.usertypes")
@EntityScan(basePackages = "com.lesiak.test.usertypes")
public class EmbeddedPostgresConfiguration {
    private static EmbeddedPostgres embeddedPostgres;

    @Bean
    @Primary
    public DataSource dataSource() throws IOException {
        embeddedPostgres = EmbeddedPostgres.builder()
                .setPort(5432)
                .start();

        return embeddedPostgres.getPostgresDatabase();
    }


}