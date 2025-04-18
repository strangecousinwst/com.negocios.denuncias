package com.negocios.denuncias.web;

import com.negocios.denuncias.model.Denuncia;
import com.negocios.denuncias.service.DenunciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
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
    public ArrayList<Denuncia> get() throws SQLException {
        return denunciaService.get();
    }

    @GetMapping("/denuncias/{id}")
    public Denuncia get(@PathVariable int id) throws SQLException {
        Denuncia d = denunciaService.get(id);
        if (d == null) { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        return d;
    }

    @DeleteMapping("/denuncias/{id}")
    public void delete(@PathVariable int id) throws SQLException {
        Denuncia d = denunciaService.remove(id);
        if (d == null) { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
    }

    @PostMapping("/denuncias")
    public void create(@RequestBody @Valid Denuncia d) throws SQLException {
        denunciaService.save(d);
    }

    @PutMapping("/denuncias/{id}")
    public Denuncia update(@PathVariable int id, @RequestBody @Valid String descricao) throws SQLException {
        Denuncia d = denunciaService.get(id);
        if (d == null) { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        d.setDescricao(descricao);
        return d;
    }
}