package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    private final String usersQuerySyntax = "SELECT USERNAME, PASSWORD, ENABLED FROM USER WHERE USERNAME=?";
    private final String  authoritiesQuerySyntax = "SELECT USERNAME, AUTHORITY FROM USER_ROLES WHERE USERNAME=?";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(usersQuerySyntax)
                .authoritiesByUsernameQuery(authoritiesQuerySyntax)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
