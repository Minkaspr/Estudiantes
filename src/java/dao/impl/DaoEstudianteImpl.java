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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
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
                .append("id_estudiante, ")
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
                estudianteDTO.setIdEstudiante(rs.getInt(1));
                byte[] imagenPerfil = rs.getBytes(2);
                estudianteDTO.setImagenPerfil(imagenPerfil);
                estudianteDTO.setNombre(rs.getString(3));
                estudianteDTO.setApellido(rs.getString(4));
                estudianteDTO.setCorreo(rs.getString(5));
                String imagenPerfilBase64 = Base64.getEncoder().encodeToString(imagenPerfil);
                estudianteDTO.setImagenPerfilBase64(imagenPerfilBase64);
                lista.add(estudianteDTO);
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    @Override
    public EstudianteDTO estudianteDet(Integer id) {
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        StringBuilder query = new StringBuilder();
        query.append("SELECT ")
                .append("nombre, ")
                .append("apellido, ")
                .append("fecha_nacimiento, ")
                .append("n_doc_identidad, ")
                .append("correo, ")
                .append("imagen_perfil, ")
                .append("peso, ")
                .append("altura, ")
                .append("genero, ")
                .append("turno, ")
                .append("fecha_registro, ")
                .append("estado ")
                .append("FROM estudiante_view ")
                .append("WHERE id_estudiante = ?");

        try (Connection cn = conexion.conexionBD()) {

            DateTimeFormatter formatterFechaNacimiento = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatterFechaRegistro = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    estudianteDTO.setNombre(rs.getString(1));
                    estudianteDTO.setApellido(rs.getString(2));
                    LocalDate fechaNacimiento = rs.getDate(3).toLocalDate();
                    estudianteDTO.setFechaNacimiento(fechaNacimiento.format(formatterFechaNacimiento));
                    estudianteDTO.setnDocumentoIdentidad(rs.getString(4));
                    estudianteDTO.setCorreo(rs.getString(5));
                    byte[] imagenPerfil = rs.getBytes(6);
                    estudianteDTO.setImagenPerfil(imagenPerfil);
                    estudianteDTO.setPeso(rs.getDouble(7));
                    estudianteDTO.setAltura(rs.getDouble(8));
                    estudianteDTO.setGenero(rs.getString(9));

                    List<String> pasatiempos = new ArrayList<>();
                    StringBuilder subquery = new StringBuilder();
                    subquery.append("SELECT p.pasatiempo ")
                            .append("FROM estudpasat e ")
                            .append("INNER JOIN pasatiempo p ")
                            .append("ON e.pasatiempo = p.id_pasatiempo ")
                            .append("WHERE e.estudiante = ?");
                    PreparedStatement psPasatiempos = cn.prepareStatement(subquery.toString());
                    psPasatiempos.setInt(1, id);
                    try (ResultSet rsPasatiempos = psPasatiempos.executeQuery()) {
                        while (rsPasatiempos.next()) {
                            pasatiempos.add(rsPasatiempos.getString(1));
                        }
                    }
                    estudianteDTO.setPasatiempos(pasatiempos);

                    estudianteDTO.setTurno(rs.getString(10));
                    LocalDateTime fechaRegistro = rs.getTimestamp(11).toLocalDateTime();
                    estudianteDTO.setFechaRegistro(fechaRegistro.format(formatterFechaRegistro));
//                    LocalDateTime fechaRegistro = rs.getTimestamp(11).toLocalDateTime();
//                    String fechaRegistroStr = fechaRegistro.format(dateFormatter) + "\n" + fechaRegistro.format(timeFormatter);
//                    estudianteDTO.setFechaRegistro(fechaRegistroStr);
                    estudianteDTO.setEstado(rs.getString(12));
                    String imagenPerfilBase64 = Base64.getEncoder().encodeToString(imagenPerfil);
                    estudianteDTO.setImagenPerfilBase64(imagenPerfilBase64);
                } else {
                    estudianteDTO = null;
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return estudianteDTO;
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
                .append("n_doc_identidad, ")
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
