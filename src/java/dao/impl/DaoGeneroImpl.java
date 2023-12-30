
package dao.impl;

import dao.DaoGenero;
import entity.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class DaoGeneroImpl implements DaoGenero{
    private final ConexionBD conexion;
    private String mensaje;

    public DaoGeneroImpl() {
        this.conexion = new ConexionBD();
    }

    @Override
    public List<Genero> generoRadBtn() {
        List<Genero> lista = null;
        String query = "SELECT id_genero, genero FROM genero";
        try (Connection cn = conexion.conexionBD()) {
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Genero genero = new Genero();
                genero.setIdGenero(rs.getInt(1));
                genero.setGenero(rs.getString(2));
                lista.add(genero);
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return lista;
    }
    
    @Override
    public String getMessage() {
        return mensaje;
    }
}
