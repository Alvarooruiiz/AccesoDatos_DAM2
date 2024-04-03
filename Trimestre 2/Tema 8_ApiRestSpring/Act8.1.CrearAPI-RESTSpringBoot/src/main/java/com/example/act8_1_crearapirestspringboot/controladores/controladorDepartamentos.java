package com.example.act8_1_crearapirestspringboot.controladores;


import com.example.act8_1_crearapirestspringboot.dao.IDepartamentoDAO;
import com.example.act8_1_crearapirestspringboot.modelo.EntidadDepartamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/departamento")
public class controladorDepartamentos {
    @Autowired
    IDepartamentoDAO departamentosDAO;


    @GetMapping
    public List<EntidadDepartamentos> buscarDepartamentos() {
        return (List<EntidadDepartamentos>) departamentosDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscEmpleadosPorId(@PathVariable(value = "id") int id) {
        Optional<EntidadDepartamentos> departamento = departamentosDAO.findById(id);
        if (departamento.isPresent()) {
            return ResponseEntity.ok().body(departamento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EntidadDepartamentos guardarDepartamento(@Validated @RequestBody EntidadDepartamentos departamento) {
        return departamentosDAO.save(departamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarDepartamento(@PathVariable(value = "id") int id) {
        Optional<EntidadDepartamentos> empleado = departamentosDAO.findById(id);
        if (empleado.isPresent()) {
            departamentosDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDepartamento(@RequestBody EntidadDepartamentos nuevoDepartamento, @PathVariable(value = "id") int id) {
        Optional<EntidadDepartamentos> departamento = departamentosDAO.findById(id);
        if (departamento.isPresent()) {
            departamento.get().setNombre(nuevoDepartamento.getNombre());
            departamento.get().setGastos(nuevoDepartamento.getGastos());
            departamento.get().setPresupuesto(nuevoDepartamento.getPresupuesto());
            return ResponseEntity.ok().body("Actualizado");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
