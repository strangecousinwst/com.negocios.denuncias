package com.negocios.denuncias.service;

import com.negocios.denuncias.database.DbMySQL;
import com.negocios.denuncias.model.Denuncia;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// @Component
@Service
public class DenunciaService {

    @Autowired
    private DbMySQL dbMySQL;


    private Map<String, Denuncia> db = new HashMap<>() {{
        put("1", new Denuncia("1", "Comentario Publicacao"));
        put("2", new Denuncia("2", "Foto Errada"));
        put("3", new Denuncia("3", "Utilizador Bot"));
    }};

    public Collection<Denuncia> get() {
        return db.values();
    }

    public Denuncia get(String id) {
        return db.get(id);
    }

    public Denuncia remove(String id) {
        return db.remove(id);
    }

    public Denuncia save(@Valid String descricao) {
        Denuncia d = new Denuncia();
        d.setId(UUID.randomUUID().toString());
        d.setDescricao(descricao);
        db.put(d.getId(), d);
        return d;
    }
}
