package fr.polytech.cinemaRESTful;

import fr.polytech.cinemaRESTful.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CinemaRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaRestfulApplication.class, args);
    }

    @Bean
    public ActorDaoServices actorDaoServices() {
        return new ActorDaoServices();
    }

    @Bean
    public CategoryDaoServices categoryDaoServices() {
        return new CategoryDaoServices();
    }

    @Bean
    public CharacterDaoServices characterDaoServices() {
        return new CharacterDaoServices();
    }

    @Bean
    public DirectorDaoServices directorDaoServices() {
        return new DirectorDaoServices();
    }

    @Bean
    public MovieDaoServices movieDaoServices() {
        return new MovieDaoServices();
    }
}