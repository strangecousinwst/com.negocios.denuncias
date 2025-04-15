package com.negocios.denuncias.web;

import com.negocios.denuncias.model.Denuncia;
import com.negocios.denuncias.service.DenunciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/denuncias")
    public Collection<Denuncia> get() {
        return denunciaService.get();
    }

    @GetMapping("/denuncias/{id}")
    public Denuncia get(@PathVariable String id) {
        Denuncia d = denunciaService.get(id);
        if (d == null) { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        return d;
    }

    @DeleteMapping("/denuncias/{id}")
    public void delete(@PathVariable String id) {
        Denuncia d = denunciaService.remove(id);
        if (d == null) { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
    }

    @PostMapping("/denuncias")
    public Denuncia create(@RequestBody @Valid String descricao) {
        return denunciaService.save(descricao);
    }
}