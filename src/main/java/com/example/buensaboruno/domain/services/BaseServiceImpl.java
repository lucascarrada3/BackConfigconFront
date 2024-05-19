package com.example.buensaboruno.domain.services;

import com.example.buensaboruno.domain.entities.Base;
import com.example.buensaboruno.repositories.BaseRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseServiceImpl <T extends Base, ID extends Serializable> implements BaseService<T, ID>{
    protected BaseRepository<T, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<T, ID> baseRepository)
    {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional
    public List<T> findAll() throws Exception {
        try{
            List<T> entities = baseRepository.findAll();
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<T> findAll(Pageable pageable) throws Exception {
        try {
            Page<T> entities = baseRepository.findAll(pageable);
            return entities;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public T findById(ID id) throws Exception {
        try {
            Optional<T> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public T save(T entity) throws Exception {
        try {
            entity = baseRepository.save(entity);
            return entity;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public T update(T entity) throws Exception {
        try {
            if (entity.getId() == null) {
                throw new ServiceException("La entidad a modificar debe contener un Id.");
            }
            return baseRepository.save(entity);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try{
            if (baseRepository.existsById(id)) {
                baseRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
