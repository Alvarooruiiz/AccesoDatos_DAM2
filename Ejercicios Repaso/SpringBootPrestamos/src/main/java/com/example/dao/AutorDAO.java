package com.example.dao;

import com.example.jpa.AutoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AutorDAO extends CrudRepository<AutoresEntity, Integer> {
}
