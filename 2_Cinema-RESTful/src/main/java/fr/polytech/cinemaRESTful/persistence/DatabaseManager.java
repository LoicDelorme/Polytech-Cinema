package fr.polytech.cinemaRESTful.persistence;

import fr.polytech.cinemaRESTful.entities.*;
import fr.polytech.cinemaRESTful.entities.Character;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseManager {

    private static SessionFactory sessionFactory = null;

    public Session getSession() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Actor.class);
            configuration.addAnnotatedClass(Category.class);
            configuration.addAnnotatedClass(Character.class);
            configuration.addAnnotatedClass(Director.class);
            configuration.addAnnotatedClass(Movie.class);

            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory.openSession();
    }
}