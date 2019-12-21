package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebSecurity
@EnableWebMvc
@EnableJpaRepositories
@SpringBootApplication
public class InvoiceHelpSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceHelpSystemApplication.class, args);
	}

}
