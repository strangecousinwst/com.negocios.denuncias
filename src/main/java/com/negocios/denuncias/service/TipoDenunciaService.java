package com.negocios.denuncias.service;

import com.negocios.denuncias.database.DbMySQL;
import com.negocios.denuncias.model.Denuncia;
import com.negocios.denuncias.model.TipoDenuncia;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

// @Component
@Service
public class TipoDenunciaService {


//    private final Map<String, TipoDenuncia> td = new HashMap<>() {{
//        put("1", new TipoDenuncia( "Utilizador"));
//        put("2", new TipoDenuncia("Comentário"));
//        put("3", new TipoDenuncia("Publicação"));
//    }};


    private DbMySQL dbMySQL;
    private ArrayList<TipoDenuncia> denuncias;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public TipoDenunciaService(DbMySQL dbMySQL) throws SQLException {
        this.dbMySQL = dbMySQL;
        conn = dbMySQL.getConnection();
    }

//    private Map<String, TipoDenuncia> td = new HashMap<>() {{
//        put("1", new TipoDenuncia( "Utilizador"));
//        put("2", new TipoDenuncia("Comentário"));
//        put("3", new TipoDenuncia("Publicação"));
//    }};

    public ArrayList<TipoDenuncia> get() throws SQLException {
        ArrayList<TipoDenuncia> tipodenuncias = new ArrayList<>();
        String query = "SELECT * FROM tipo_denuncia";
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
            TipoDenuncia td = new TipoDenuncia();
            td.setId(rs.getInt("id"));
            td.setDescricao(rs.getString("descricao"));
            td.setIs_Active(rs.getBoolean("is_active"));

            tipodenuncias.add(td);
        }
        return tipodenuncias;
    }

    public TipoDenuncia get(int id) throws SQLException {
        TipoDenuncia td = new TipoDenuncia();
        String query = "SELECT * FROM tipo_denuncia WHERE id = ?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            td.setId(rs.getInt("id"));
            td.setDescricao(rs.getString("descricao"));
            td.setIs_Active(rs.getBoolean("is_active"));
        }
        return td ;
    }

    public TipoDenuncia remove(int id) throws SQLException {
        TipoDenuncia td = new TipoDenuncia();
        String query = "DELETE FROM tipo_denuncia WHERE id = ?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        return td;
    }

    public void save(TipoDenuncia td) throws SQLException {
        String query = "INSERT INTO tipo_denuncia (descricao) VALUES (?)";
        ps = conn.prepareStatement(query);
        ps.setString(1, td.getDescricao());
        ps.executeUpdate();
    }

    public void update(TipoDenuncia td) throws SQLException {
        String query = "UPDATE tipo_denuncia SET descricao = ?, SET is_active = ? WHERE id = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, td.getDescricao());
        ps.setInt(2, td.getId());
        ps.setBoolean(3, td.getIs_Active());
        ps.executeUpdate();
    }

    public void deactivate(TipoDenuncia td) throws SQLException {
        String query = "UPDATE tipo_denuncia SET is_active = ? " +
                "WHERE id = ?";

        ps = conn.prepareStatement(query);
        ps.setBoolean(1, td.getIs_Active());
        ps.setInt(2, td.getId());
        ps.executeUpdate();


    }
//    public TipoDenuncia save(@Valid String descricao) {
//        TipoDenuncia novoTipo = new TipoDenuncia();
//        novoTipo.setId(UUID.randomUUID().toString());
//        novoTipo.setDescricao(descricao);
//        td.put(novoTipo.getId(), novoTipo);
//        return novoTipo;
//    }
}
