package fr.polytech.cinemaRESTful.services;

import java.util.List;

public interface DaoServices<T> {

    public T get(Object id);

    public List<T> getAll();

    public void insert(T object);

    public void update(T object);

    public void delete(T object);
}