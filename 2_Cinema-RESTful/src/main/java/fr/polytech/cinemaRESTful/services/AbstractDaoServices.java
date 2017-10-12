package fr.polytech.cinemaRESTful.services;

import fr.polytech.cinemaRESTful.persistence.DatabaseManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AbstractDaoServices<T> implements DaoServices<T> {

    @Autowired
    private DatabaseManager databaseManager;

    private final Class<T> entityClass;

    public AbstractDaoServices(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T get(Object id) {
        Session session = this.databaseManager.getSession();

        session.beginTransaction();
        T entity = session.find(this.entityClass, id);
        session.getTransaction().commit();

        session.close();

        return entity;
    }

    @Override
    public List<T> getAll() {
        Session session = this.databaseManager.getSession();

        session.beginTransaction();
        CriteriaQuery<T> criteriaQuery = session.getCriteriaBuilder().createQuery(this.entityClass);
        List<T> entities = session.createQuery(criteriaQuery.select(criteriaQuery.from(this.entityClass))).getResultList();
        session.getTransaction().commit();

        session.close();

        return entities;
    }

    @Override
    public void insert(T object) {
        Session session = this.databaseManager.getSession();

        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void update(T object) {
        Session session = this.databaseManager.getSession();

        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void delete(T object) {
        Session session = this.databaseManager.getSession();

        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();

        session.close();
    }
}