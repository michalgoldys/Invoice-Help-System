package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry resourceHandlerRegistry){
        resourceHandlerRegistry.addResourceHandler("/bootstrap/**").addResourceLocations("/webjars/bootstrap/");
        resourceHandlerRegistry.addResourceHandler("/jquery/**").addResourceLocations("/webjars/jquery/");
        resourceHandlerRegistry.addResourceHandler("/img/**").addResourceLocations("/resources/static/img/");
    }
}
