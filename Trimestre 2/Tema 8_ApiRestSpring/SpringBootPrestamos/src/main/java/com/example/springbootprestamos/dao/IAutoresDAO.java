package com.example.springbootprestamos.dao;

import com.example.springbootprestamos.modelo.AutoresJPAEntity;
import org.springframework.data.repository.CrudRepository;

public interface IAutoresDAO extends CrudRepository<AutoresJPAEntity, Integer> {
    AutoresJPAEntity findByIdAutor(int id);
}
