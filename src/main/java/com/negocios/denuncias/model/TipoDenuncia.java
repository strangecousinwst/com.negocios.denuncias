package com.negocios.denuncias.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public class TipoDenuncia {

    private int id;
    @NotEmpty
    private String descricao;


//Construtores-----------------------------------------------
    public TipoDenuncia() {
    }
    public TipoDenuncia(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    //------------------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
