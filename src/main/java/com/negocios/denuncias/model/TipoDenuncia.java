package com.negocios.denuncias.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public class TipoDenuncia {

    private int id;
    @NotEmpty
    private String descricao;

    private boolean is_active;


//Construtores-----------------------------------------------
    public TipoDenuncia() {
    }
    public TipoDenuncia(int id, String descricao, boolean is_active) {
        this.id = id;
        this.descricao = descricao;
        this.is_active = is_active;
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

    public boolean getIs_Active() {
        return is_active;
    }
    public void setIs_Active(boolean is_active) {
        this.is_active = is_active;
    }
}
