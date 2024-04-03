package com.example.act8_1_crearapirestspringboot.dao;

import com.example.act8_1_crearapirestspringboot.modelo.EntidadDepartamentos;
import org.springframework.data.repository.CrudRepository;

public interface IDepartamentoDAO extends CrudRepository<EntidadDepartamentos, Integer> {
}
