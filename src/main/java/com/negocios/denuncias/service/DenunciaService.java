package com.negocios.denuncias.service;

import com.negocios.denuncias.database.DbMySQL;
import com.negocios.denuncias.model.Denuncia;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

// @Component
@Service
public class DenunciaService {

    private final Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public DenunciaService(DbMySQL dbMySQL) throws SQLException {
        conn = dbMySQL.getConnection();
    }

   // private Map<String, Denuncia> db = new HashMap<>() {{
   //     put("1", new Denuncia("1", "Comentario Publicacao"));
   //     put("2", new Denuncia("2", "Foto Errada"));
   //     put("3", new Denuncia("3", "Utilizador Bot"));
   // }};

    public ArrayList<Denuncia> get() throws SQLException {
        ArrayList<Denuncia> denuncias = new ArrayList<>();
        String query = "SELECT * FROM denuncia";
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
            Denuncia d = new Denuncia();
            d.setId(rs.getInt("id"));
            d.setDescricao(rs.getString("descricao"));
            d.setDenunciadorId(rs.getInt("denunciador_id"));
            d.setDenunciadoId(rs.getInt("denunciado_id"));
            d.setData(rs.getDate("data"));
            d.setTipoDenunciaId(rs.getInt("tipo_denuncia_id"));
            denuncias.add(d);
        }
        return denuncias;
    }

    public Denuncia get(int id) throws SQLException {
        Denuncia d = new Denuncia();
        String query = "SELECT * FROM denuncia WHERE id = ?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            d.setId(rs.getInt("id"));
            d.setDescricao(rs.getString("descricao"));
            d.setDenunciadorId(rs.getInt("denunciador_id"));
            d.setDenunciadoId(rs.getInt("denunciado_id"));
            d.setData(rs.getDate("data"));
            d.setTipoDenunciaId(rs.getInt("tipo_denuncia_id"));
            return d;
        }
        return null;
    }

    public Denuncia remove(int id) throws SQLException {
        Denuncia d = new Denuncia();
        String query = "DELETE FROM denuncia WHERE id = ?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        return d;
    }

    public void save(Denuncia d) throws SQLException {
        String query = "INSERT INTO denuncia (descricao, " +
                "denunciador_id" +
                "denunciado_id" +
                "tipo_denuncia_id)" +
                "VALUES (?, ?, ?, ?)";
        ps = conn.prepareStatement(query);
        ps.setString(1, d.getDescricao());
        ps.setInt(2, d.getDenunciadorId());
        ps.setInt(3, d.getDenunciadoId());
        ps.setInt(4, d.getTipoDenunciaId());
        ps.executeUpdate();
    }

    public void update(Denuncia d) throws SQLException {
        String query = "UPDATE denuncia SET descricao = ?, " +
                "denunciador_id = ?, " +
                "denunciado_id = ?, " +
                "tipo_denuncia_id = ?  " +
                "WHERE id = ?";

        ps = conn.prepareStatement(query);
        ps.setString(1, d.getDescricao());
        ps.setInt(2, d.getDenunciadorId());
        ps.setInt(3, d.getDenunciadoId());
        ps.setInt(4, d.getTipoDenunciaId());
        ps.setInt(5, d.getId());
        ps.executeUpdate();
    }
}
