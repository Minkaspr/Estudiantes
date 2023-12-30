
package dao.impl;

import dao.DaoPasatiempo;
import entity.Pasatiempo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class DaoPasatiempoImpl implements DaoPasatiempo{
    private final ConexionBD conexion;
    private String mensaje;

    public DaoPasatiempoImpl() {
        this.conexion = new ConexionBD();
    }

    @Override
    public List<Pasatiempo> pasatiempoCheBox() {
        List<Pasatiempo> lista = null;
        String query = "SELECT id_pasatiempo, pasatiempo FROM pasatiempo";
        try (Connection cn = conexion.conexionBD()) {
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Pasatiempo pasatiempo = new Pasatiempo();
                pasatiempo.setIdPasatiempo(rs.getInt(1));
                pasatiempo.setPasatiempo(rs.getString(2));
                lista.add(pasatiempo);
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
