package com.negocios.denuncias.service;

import com.negocios.denuncias.model.TipoDenuncia;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// @Component
@Service
public class TipoDenunciaService {

    private Map<String, TipoDenuncia> td = new HashMap<>() {{
        put("1", new TipoDenuncia( "Utilizador"));
        put("2", new TipoDenuncia("Comentário"));
        put("3", new TipoDenuncia("Publicação"));
    }};

    public Collection<TipoDenuncia> get() {
        return td.values();
    }

    public TipoDenuncia get(String id) {
        return td.get(id);
    }

    public TipoDenuncia remove(String id) {
        return td.remove(id);
    }

    public TipoDenuncia save(@Valid String descricao) {
        TipoDenuncia novoTipo = new TipoDenuncia();
        novoTipo.setId(UUID.randomUUID().toString());
        novoTipo.setDescricao(descricao);
        td.put(novoTipo.getId(), novoTipo);
        return novoTipo;
    }
}
