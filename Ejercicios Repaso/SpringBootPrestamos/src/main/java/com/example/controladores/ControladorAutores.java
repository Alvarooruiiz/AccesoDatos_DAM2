package com.example.controladores;

import com.example.dao.AutorDAO;
import com.example.dto.AutorDTO;
import com.example.jpa.AutoresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/autores")
public class ControladorAutores {
    @Autowired
    AutorDAO autorDAO;

    @GetMapping
    public List<AutoresEntity> buscarAutores() {
        return (List<AutoresEntity>) autorDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoresEntity> buscarAutoresPorId(@PathVariable(value = "id")int id) {
        Optional<AutoresEntity> autor = autorDAO.findById(id);
        if (autor.isPresent()) {
            return ResponseEntity.ok().body(autor.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public AutoresEntity guardarAutores(@Validated @RequestBody AutoresEntity autor) {
        return  autorDAO.save(autor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarAutor(@PathVariable(value = "id")int id) {
        Optional<AutoresEntity> autor = autorDAO.findById(id);
        if (autor.isPresent()) {
            autorDAO.deleteById(id);
            return ResponseEntity.ok().body("Autor Borrado");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAutor(@RequestBody AutoresEntity nuevoAutor,@PathVariable(value =  "id") int id) {
        Optional<AutoresEntity> autor = autorDAO.findById(id);
        if (autor.isPresent()) {
            autor.get().setNombreAutor(nuevoAutor.getNombreAutor());
            autor.get().setPais(nuevoAutor.getPais());
            autorDAO.save(autor.get());
            return ResponseEntity.ok().body("Update");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    //------------------DTO---------------------//

    @PostMapping("/agregar-multiples")
    public ResponseEntity<?> agregarMultiplesAutores(@Validated @RequestBody List<AutorDTO> autoresDTO) {
        List<AutoresEntity> autoresEntities = autoresDTO.stream()
                .map(this::convertirDTOaEntity).toList();

        autorDAO.saveAll(autoresEntities);
        return ResponseEntity.ok().body("Autores agregados correctamente");
    }

    private AutoresEntity convertirDTOaEntity(AutorDTO autorDTO) {
        AutoresEntity autorEntity = new AutoresEntity();
        autorEntity.setIdAutor(autorDTO.getIdAutor());
        autorEntity.setNombreAutor(autorDTO.getNombreAutor());
        autorEntity.setPais(autorDTO.getPais());
        return autorEntity;
    }
}
