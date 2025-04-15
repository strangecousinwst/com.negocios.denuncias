package com.negocios.denuncias.repository;

import com.negocios.denuncias.model.Denuncia;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DenunciaRepository extends Repository<Denuncia,String> {

    List<Denuncia> findByDescricao(String nome);


}
