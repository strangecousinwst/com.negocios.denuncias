package com.negocios.denuncias.web;

import com.negocios.denuncias.model.TipoDenuncia;
import com.negocios.denuncias.service.TipoDenunciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class TipoDenunciaController {

    @Autowired
    private TipoDenunciaService tipoDenunciaService;

    @GetMapping("/tipodenuncias")
    public Collection<TipoDenuncia> get() {
        return tipoDenunciaService.get();
    }

    @GetMapping("/tipodenuncias/{id}")
    public TipoDenuncia get(@PathVariable String id) {
        TipoDenuncia td = tipoDenunciaService.get(id);
        if (td == null) { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        return td;
    }

    @DeleteMapping("/tipodenuncias/{id}")
    public void delete(@PathVariable String id) {
        TipoDenuncia td = tipoDenunciaService.remove(id);
        if (td == null) { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
    }

    @PostMapping("/tipodenuncias")
    public TipoDenuncia create(@RequestBody @Valid String descricao) {
        return tipoDenunciaService.save(descricao);
    }
}