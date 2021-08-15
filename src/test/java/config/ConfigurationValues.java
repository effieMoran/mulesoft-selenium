package config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(name="myProperties", value= "application.properties")
public class ConfigurationValues {

    @Value("${credentials.username}")
    public static String username = "default";

    public static String password = "default";
}
