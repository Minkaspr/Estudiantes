
package dao.impl;

import dao.DaoTurno;
import entity.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class DaoTurnoImpl implements DaoTurno{
    private final ConexionBD conexion;
    private String mensaje;

    public DaoTurnoImpl() {
        this.conexion = new ConexionBD();
    }

    @Override
    public List<Turno> turnoSelOp() {
        List<Turno> lista = null;
        String query = "SELECT id_turno, turno FROM turno";
        try (Connection cn = conexion.conexionBD()) {
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Turno turno = new Turno();
                turno.setIdTurno(rs.getInt(1));
                turno.setTurno(rs.getString(2));
                lista.add(turno);
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
