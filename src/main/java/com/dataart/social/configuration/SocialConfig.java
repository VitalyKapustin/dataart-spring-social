package com.dataart.social.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

/**
 * Created by vkapustin on 01.10.15.
 */
@Configuration
@ComponentScan("com.dataart.social.client")
@PropertySource("classpath:application.properties")
public class SocialConfig implements SocialConfigurer {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        /**
         * If we wanted to add support for connecting to other providers, we would simply register
         * their connection factories here in the same way as FacebookConnectionFactory.
         */
        connectionFactoryConfigurer.addConnectionFactory(new FacebookConnectionFactory(
                environment.getProperty("facebook.clientId"),
                environment.getProperty("facebook.clientSecret")));
    }

    @Override
    public UserIdSource getUserIdSource() {
        return null;
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return null;
    }

    @Bean
    public Facebook getFacebook() {
        return new FacebookTemplate("CAACEdEose0cBALuAnyadxrPLfWXxINZCQoqZAQJYeZBFmoFOIHjjz9acLuAETx0NwVOUwFnhMKWuBZB446yJIJ1aVZCIkpcHeMvnuTP5KwnMLXXxszry6iWqmtqEKFiV2fIxMPmDhyuUl3bLL4d5iDq6WDXOsBdRa9WbNLHpD4EI2KTVaoxwb2LCVmumZATSxhdqU6ZApKDHBHzoA4qGem8");
    }
}
