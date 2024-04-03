package com.example.examenapirestservidor.DAO;

import com.example.examenapirestservidor.Modelo.UsuariosJPAEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUsuariosDAO extends CrudRepository<UsuariosJPAEntity, Integer> {
}
