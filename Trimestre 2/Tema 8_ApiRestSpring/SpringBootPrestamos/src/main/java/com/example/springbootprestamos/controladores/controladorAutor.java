package com.example.springbootprestamos.controladores;

import com.example.springbootprestamos.dao.IAutoresDAO;
import com.example.springbootprestamos.modelo.AutoresJPAEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/autores")
public class controladorAutor {
    @Autowired
    IAutoresDAO autorDAO;



    @GetMapping
    public List<AutoresJPAEntity> buscarAutores() {
        return (List<AutoresJPAEntity>) autorDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoresJPAEntity> buscarAutorPorId(@PathVariable(value = "id") Integer id) {
        Optional<AutoresJPAEntity> autor = autorDAO.findById(id);

        return autor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarAutor(@Validated @RequestBody AutoresJPAEntity nuevoAutor,
                                                  @PathVariable(value = "id") Integer id) {
        Optional<AutoresJPAEntity> autorAntiguo = autorDAO.findById(id);

        return autorAntiguo.map(autor -> {
            autor.setNombreAutor(nuevoAutor.getNombreAutor());
            autor.setPais(nuevoAutor.getPais());
            autorDAO.save(autor);
            return ResponseEntity.ok().body("Updated");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAutor(@PathVariable(value = "id") Integer id) {

        if (autorDAO.existsById(id)) {
            autorDAO.deleteById(id);
            return ResponseEntity.ok().body("Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public AutoresJPAEntity guardarAutor(@Validated @RequestBody AutoresJPAEntity autor) {
        return autorDAO.save(autor);
    }


//    @GetMapping
//    public List<AutoresJPAEntity> buscarAutores() {
//        return (List<AutoresJPAEntity>) autorDAO.findAll();
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<AutoresJPAEntity> buscarAutorPorId(@PathVariable(value = "id") Integer id) {
//        Optional<AutoresJPAEntity> autor = autorDAO.findById(id);
//
//        if (autor.isPresent()) {
//            return ResponseEntity.ok().body(autor.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> actualizarAutor(@Validated @RequestBody AutoresJPAEntity nuevoAutor,
//                                                    @PathVariable(value = "id") Integer id) {
//        Optional<AutoresJPAEntity> autorAntiguo = autorDAO.findById(id);
//
//        if (autorAntiguo.isPresent()) {
//            AutoresJPAEntity autor = autorAntiguo.get();
//            autor.setNombreAutor(nuevoAutor.getNombreAutor());
//            autor.setPais(nuevoAutor.getPais());
//            autorDAO.save(autor);
//            return ResponseEntity.ok().body("Updated");
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> eliminarAutor(@PathVariable(value = "id") Integer id) {
//
//        Optional<AutoresJPAEntity> autor = autorDAO.findById(id);
//
//        if (autor.isPresent()) {
//            autorDAO.delete(autor.get());
//            return ResponseEntity.ok().body("Deleted");
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }


}
