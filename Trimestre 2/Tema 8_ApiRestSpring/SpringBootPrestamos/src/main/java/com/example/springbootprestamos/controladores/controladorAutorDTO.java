package com.example.springbootprestamos.controladores;

import com.example.springbootprestamos.dao.IAutoresDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-rest/dto")
public class controladorAutorDTO {

    @Autowired
    IAutoresDAO autoresDAO;
}
