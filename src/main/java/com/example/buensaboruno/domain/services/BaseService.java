package com.example.buensaboruno.domain.services;

import com.example.buensaboruno.domain.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends Base, ID extends Serializable> {
    public List<T> findAll() throws Exception;
    public Page<T> findAll(Pageable pageable) throws Exception;
    public T findById(ID id) throws Exception;
    public T save(T entity) throws Exception;
    public T update(T entity) throws Exception;
    public boolean delete(ID id) throws Exception;

    List<T> search(String string) throws Exception;

    Page<T> search(String string, Pageable pageable) throws Exception;


}