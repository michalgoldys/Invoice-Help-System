package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConnectionConfiguration {

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder
                .create()
                .username("sa")
                .password("")
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testdb")
                .build();
    }
}
