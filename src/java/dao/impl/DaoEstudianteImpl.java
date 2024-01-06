package dao.impl;

import dao.DaoEstudiante;
import dto.EstudianteDTO;
import entity.EstudPasat;
import entity.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class DaoEstudianteImpl implements DaoEstudiante {

    private final ConexionBD conexion;
    private String mensaje;

    public DaoEstudianteImpl() {
        this.conexion = new ConexionBD();
    }

    @Override
    public List<EstudianteDTO> estudianteSel() {
        List<EstudianteDTO> lista = null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT ")
                .append("imagen_perfil, ")
                .append("nombre, ")
                .append("apellido, ")
                .append("correo ")
                .append("FROM estudiante_view");
        try (Connection cn = conexion.conexionBD()) {
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                EstudianteDTO estudianteDTO = new EstudianteDTO();
                estudianteDTO.setImagenPerfil(rs.getBytes(1));
                estudianteDTO.setNombre(rs.getString(2));
                estudianteDTO.setApellido(rs.getString(3));
                estudianteDTO.setCorreo(rs.getString(4));
                lista.add(estudianteDTO);
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    @Override
    public EstudianteDTO estudianteDet(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Estudiante estudianteGet(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String estudianteIns(Estudiante estudiante) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO estudiante( ")
                .append("nombre, ")
                .append("apellido, ")
                .append("fecha_nacimiento, ")
                .append("n_documento_identidad, ")
                .append("correo, ")
                .append("imagen_perfil, ")
                .append("peso, ")
                .append("altura, ")
                .append("genero, ")
                .append("turno, ")
                .append("fecha_registro, ")
                .append("estado ")
                .append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ");
        try (Connection cn = conexion.conexionBD()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setDate(3, java.sql.Date.valueOf(estudiante.getFechaNacimiento()));
            ps.setString(4, estudiante.getnDocumentoIdentidad());
            ps.setString(5, estudiante.getCorreo());
            ps.setBytes(6, estudiante.getImagenPerfil());
            ps.setDouble(7, estudiante.getPeso());
            ps.setDouble(8, estudiante.getAltura());
            ps.setInt(9, estudiante.getGenero());
            ps.setInt(10, estudiante.getTurno());
            ps.setTimestamp(11, java.sql.Timestamp.valueOf(estudiante.getFechaRegistro()));
            ps.setString(12, estudiante.getEstado());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "cero filas insertadas";
            } else {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int idEstudiante = rs.getInt(1);
                    for (EstudPasat pasatiempo : estudiante.getPasatiempos()) {
                        sql = new StringBuilder();
                        sql.append("INSERT INTO estudpasat(estudiante, pasatiempo) VALUES (?, ?)");
                        ps = cn.prepareStatement(sql.toString());
                        ps.setInt(1, idEstudiante);
                        ps.setInt(2, pasatiempo.getPasatiempo());
                        ps.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String estudianteUpd(Estudiante estudiante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String estudianteDel(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getMessage() {
        return mensaje;
    }
}
