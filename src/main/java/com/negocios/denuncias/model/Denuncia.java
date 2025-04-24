package com.negocios.denuncias.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class Denuncia {

  private int id;

  @NotEmpty
  private String descricao;

  private int denunciadorId;

  private int denunciadoId;

  private Date data;

  private int tipoDenunciaId;

  private boolean is_active;

  public Denuncia() {
  }

  public Denuncia(String descricao, int denunciadorId, int denunciadoId, int tipoDenunciaId) {
    this.descricao = descricao;
    this.denunciadorId = denunciadorId;
    this.denunciadoId = denunciadoId;
    this.tipoDenunciaId = tipoDenunciaId;
  }

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

  public int getDenunciadorId() {
    return denunciadorId;
  }

  public void setDenunciadorId(int denunciadorId) {
    this.denunciadorId = denunciadorId;
  }

  public int getDenunciadoId() {
    return denunciadoId;
  }

  public void setDenunciadoId(int denunciadoId) {
    this.denunciadoId = denunciadoId;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public int getTipoDenunciaId() {
    return tipoDenunciaId;
  }

  public void setTipoDenunciaId(int tipoDenunciaId) {
    this.tipoDenunciaId = tipoDenunciaId;
  }

  public boolean getIsActive() {
    return is_active;
  }

  public void setIsActive(boolean is_active) {
    this.is_active = is_active;
  }
}
