package com.negocios.denuncias.model;

import com.negocios.denuncias.repository.DenunciaRepository;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Denuncia {

    @Autowired
    private DenunciaRepository denunciaRepository;

    private String id;

    @NotEmpty
    private String descricao;

    public Denuncia() {
    }

    public Denuncia(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Denuncia> findAll() {
        List<Denuncia> d = new ArrayList<Denuncia>();
        denunciaRepository.findByDescricao(descricao).forEach(denuncia -> d.add(denuncia));
        return d;
    }

}
