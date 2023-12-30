
package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Estudiante {
    private Integer idEstudiante;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nDocumentoIdentidad;
    private String correoElectronico;
    private byte[] imagenPerfil;
    private double peso;
    private double altura;
    private Integer genero;
    private Integer pasatiempo;
    private Integer turno;
    private LocalDateTime fechaRegistro;
    private String estado;

    public Estudiante() {
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getPasatiempo() {
        return pasatiempo;
    }

    public void setPasatiempo(int pasatiempo) {
        this.pasatiempo = pasatiempo;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
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
