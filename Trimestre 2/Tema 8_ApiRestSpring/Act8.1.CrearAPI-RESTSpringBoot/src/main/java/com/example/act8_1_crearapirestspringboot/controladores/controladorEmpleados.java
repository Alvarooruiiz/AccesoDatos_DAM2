package com.example.act8_1_crearapirestspringboot.controladores;

import com.example.act8_1_crearapirestspringboot.dao.IEmpleadoDAO;
import com.example.act8_1_crearapirestspringboot.modelo.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api-rest/empleado")
public class controladorEmpleados {
    @Autowired
    IEmpleadoDAO empleadosDAO;

    @GetMapping
    public List<EntidadEmpleados> buscarEmpleados() {
        return (List<EntidadEmpleados>) empleadosDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscEmpleadosPorId(@PathVariable(value = "id") int id) {
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);
        if (empleado.isPresent()) {
            return ResponseEntity.ok().body(empleado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EntidadEmpleados guardarEmpleado(@Validated @RequestBody EntidadEmpleados empleado) {
        return empleadosDAO.save(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEmpleado(@PathVariable(value = "id") int id) {
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);
        if (empleado.isPresent()) {
            empleadosDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpleado(@RequestBody EntidadEmpleados nuevoEmpleado, @PathVariable(value = "id") int id) {
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);
        if (empleado.isPresent()) {
            empleado.get().setNombre(nuevoEmpleado.getNombre());
            empleado.get().setNif(nuevoEmpleado.getNif());
            empleado.get().setApellido1(nuevoEmpleado.getApellido1());
            empleado.get().setApellido2(nuevoEmpleado.getApellido2());
            empleado.get().setIdDepartamento(nuevoEmpleado.getIdDepartamento());
            return ResponseEntity.ok().body("Actualizado");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}