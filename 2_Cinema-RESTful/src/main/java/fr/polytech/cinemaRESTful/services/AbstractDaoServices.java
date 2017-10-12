package fr.polytech.cinemaRESTful.services;

import fr.polytech.cinemaRESTful.persistence.DatabaseManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class AbstractDaoServices<T> implements DaoServices<T> {

    @Autowired
    private DatabaseManager databaseManager;

    private final Class<T> entityClass;

    public AbstractDaoServices(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T get(Serializable id) {
        final Session session = this.databaseManager.getSession();

        session.beginTransaction();
        final T entity = session.get(this.entityClass, id);
        session.getTransaction().commit();

        session.close();

        return entity;
    }

    @Override
    public List<T> getAll() {
        final Session session = this.databaseManager.getSession();

        session.beginTransaction();
        final List<T> entities = session.createCriteria(this.entityClass).list();
        session.getTransaction().commit();

        session.close();

        return entities;
    }

    @Override
    public void insert(T object) {
        final Session session = this.databaseManager.getSession();

        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void update(T object) {
        final Session session = this.databaseManager.getSession();

        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void delete(T object) {
        final Session session = this.databaseManager.getSession();

        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();

        session.close();
    }
}