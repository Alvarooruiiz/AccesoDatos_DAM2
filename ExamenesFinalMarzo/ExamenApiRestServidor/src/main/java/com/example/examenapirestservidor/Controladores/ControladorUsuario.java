package com.example.examenapirestservidor.Controladores;


import com.example.examenapirestservidor.DAO.IUsuariosDAO;
import com.example.examenapirestservidor.Modelo.UsuariosJPAEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/usuarios")
public class ControladorUsuario {

    @Autowired
    private IUsuariosDAO usuariosDAO;

    @GetMapping
    public List<UsuariosJPAEntity> buscarUsuarios() {
        return (List<UsuariosJPAEntity>) usuariosDAO.findAll();
    }

    @PostMapping
    public UsuariosJPAEntity guardarUsuario(@Validated @RequestBody UsuariosJPAEntity usuario) {
        System.out.println("ID del usuario: " + usuario.getIdUsuario());
        return usuariosDAO.save(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarUsuario(@PathVariable(value = "id") int id) {
        Optional<UsuariosJPAEntity> usuario = usuariosDAO.findById(id);
        if (usuario.isPresent()) {
            usuariosDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
