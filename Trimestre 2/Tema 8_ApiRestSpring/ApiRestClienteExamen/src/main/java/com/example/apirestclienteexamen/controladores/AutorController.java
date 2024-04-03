package com.example.apirestclienteexamen.controladores;

import com.example.apirestclienteexamen.modelo.Autor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private List<Autor> autores = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Autor>> getAutores() {
        return ResponseEntity.ok(autores);
    }

    @PostMapping
    public ResponseEntity<Autor> crearAutor(@RequestBody Autor autor) {
        autores.add(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(autor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorPorId(@PathVariable Long id) {
        Autor autor = encontrarAutorPorId(id);
        if (autor != null) {
            return ResponseEntity.ok(autor);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable Long id, @RequestBody Autor autorActualizado) {
        Autor autorExistente = encontrarAutorPorId(id);
        if (autorExistente != null) {
            autorExistente.setNombre(autorActualizado.getNombre());
            autorExistente.setPais(autorActualizado.getPais());
            return ResponseEntity.ok(autorExistente);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarAutor(@PathVariable Long id) {
        Autor autor = encontrarAutorPorId(id);
        if (autor != null) {
            autores.remove(autor);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Autor encontrarAutorPorId(Long id) {
        return autores.stream()
                .filter(autor -> autor.getId()==(id))
                .findFirst()
                .orElse(null);
    }
}
