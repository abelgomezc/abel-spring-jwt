package com.abel.services;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Abel Gomez
 * @param <T>
 * @param <ID>
 */
public interface GenericService <T, ID extends Serializable>{

    public T save(T entity);

    public T findById(ID id);

    public List<T> findByAll();

    public void delete(ID id);


}