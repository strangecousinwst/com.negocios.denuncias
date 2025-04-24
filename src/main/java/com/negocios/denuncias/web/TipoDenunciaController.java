package com.negocios.denuncias.web;

import com.negocios.denuncias.model.TipoDenuncia;
import com.negocios.denuncias.service.TipoDenunciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.*;

@RestController
public class TipoDenunciaController {

    private final TipoDenunciaService tipoDenunciaService;

    public TipoDenunciaController(TipoDenunciaService tipoDenunciaService) {
        this.tipoDenunciaService = tipoDenunciaService;
    }

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

    @PutMapping("/tipodenunciasdeactivate/{id}")
    public TipoDenuncia deactivate(@PathVariable int id) throws SQLException {
        TipoDenuncia td = tipoDenunciaService.get(id);
        if (td == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        td.setIs_Active(false);
        tipoDenunciaService.deactivate(td);
        return td;
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
        tipoDenunciaService.update(td);
        return td;
    }
}