package com.negocios.denuncias.web;

import com.negocios.denuncias.model.Denuncia;
import com.negocios.denuncias.model.TipoDenuncia;
import com.negocios.denuncias.service.TipoDenunciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.*;

@RestController
public class TipoDenunciaController {

    @Autowired
    private TipoDenunciaService tipoDenunciaService;

    @GetMapping("/tipodenuncias")
    public ArrayList<TipoDenuncia> get() throws SQLException {
        return tipoDenunciaService.get();
    }

    @GetMapping("/tipodenuncias/{id}")
    public TipoDenuncia get(@PathVariable int id) throws SQLException {
        TipoDenuncia td = tipoDenunciaService.get(id);
        if (td == null) { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        return td;
    }

    @DeleteMapping("/tipodenuncias/{id}")
    public void delete(@PathVariable int id) throws SQLException {
        TipoDenuncia td = tipoDenunciaService.remove(id);
        if (td == null) { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
    }

    @PostMapping("/tipodenuncias")
    public void create(@RequestBody @Valid TipoDenuncia td) throws SQLException {
       tipoDenunciaService.save(td);
    }

    @PutMapping("/tipodenuncias/{id}")
    public TipoDenuncia update(@PathVariable int id, @RequestBody @Valid String descricao) throws SQLException {
        TipoDenuncia td = tipoDenunciaService.get(id);
        if (td == null) { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        td.setDescricao(descricao);
        return td;
    }
}