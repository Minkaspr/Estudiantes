
package dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EstudianteDTO {
    private Integer idEstudiante;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nDocumentoIdentidad;
    private String correo;
    private byte[] imagenPerfil;
    private double peso;
    private double altura;
    private String genero;
    private String pasatiempo;
    private String turno;
    private LocalDateTime fechaRegistro;
    private String estado;

    public EstudianteDTO() {
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getnDocumentoIdentidad() {
        return nDocumentoIdentidad;
    }

    public void setnDocumentoIdentidad(String nDocumentoIdentidad) {
        this.nDocumentoIdentidad = nDocumentoIdentidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public byte[] getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(byte[] imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPasatiempo() {
        return pasatiempo;
    }

    public void setPasatiempo(String pasatiempo) {
        this.pasatiempo = pasatiempo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
