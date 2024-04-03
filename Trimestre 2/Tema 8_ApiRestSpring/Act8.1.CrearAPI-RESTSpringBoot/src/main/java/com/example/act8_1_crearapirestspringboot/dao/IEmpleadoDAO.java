package com.example.act8_1_crearapirestspringboot.dao;

import com.example.act8_1_crearapirestspringboot.modelo.EntidadEmpleados;
import org.springframework.data.repository.CrudRepository;

public interface IEmpleadoDAO extends CrudRepository<EntidadEmpleados, Integer> {
}
