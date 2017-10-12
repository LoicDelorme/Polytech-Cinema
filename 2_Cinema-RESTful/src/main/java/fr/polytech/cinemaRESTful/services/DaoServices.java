package fr.polytech.cinemaRESTful.services;

import java.io.Serializable;
import java.util.List;

public interface DaoServices<T> {

    public T get(Serializable id);

    public List<T> getAll();

    public void insert(T object);

    public void update(T object);

    public void delete(T object);
}