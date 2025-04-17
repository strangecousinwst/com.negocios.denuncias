package com.negocios.denuncias.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TipoDenuncia {

    private String id;
    @NotEmpty
    private String descricao;

    public TipoDenuncia() {
    }
    public TipoDenuncia(String descricao) {
        this.id = UUID.randomUUID().toString();
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
}
