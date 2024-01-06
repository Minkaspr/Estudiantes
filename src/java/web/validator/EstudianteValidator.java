package web.validator;

import dao.DaoEstudiante;
import dao.DaoGenero;
import dao.DaoPasatiempo;
import dao.DaoTurno;
import dao.impl.DaoEstudianteImpl;
import dao.impl.DaoGeneroImpl;
import dao.impl.DaoPasatiempoImpl;
import dao.impl.DaoTurnoImpl;
import dto.EstudianteDTO;
import entity.EstudPasat;
import entity.Estudiante;
import entity.Genero;
import entity.Pasatiempo;
import entity.Turno;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class EstudianteValidator {

    private final HttpServletRequest request;
    private final DaoEstudiante daoEstudiante;

    public EstudianteValidator(HttpServletRequest request) {
        this.request = request;
        this.daoEstudiante = new DaoEstudianteImpl();
    }

//    public String estudianteSel(){
//        String result = null;
//        List<EstudianteDTO> list = daoEstudiante.estudianteSel();
//        if (list != null) {
//            request.setAttribute("estudiantes", list);
//        } else { 
//            result = daoEstudiante.getMessage();
//        }
//        return result; 
//    }
    public String estudianteSel() {
        String result = null;
        List<EstudianteDTO> list = daoEstudiante.estudianteSel();
        if (list != null) {
            request.setAttribute("estudiantes", list);
        } else {
            result = daoEstudiante.getMessage();
        }
        return result;
    }

    public String estudianteDf() { // Data filling <> Llenado de datos
        String result = null;
        // Obtenemos la lista de 'Generos', 'Turnos' y 'Pasatiempos'
        DaoGenero daoGenero = new DaoGeneroImpl();
        DaoPasatiempo daoPasatiempo = new DaoPasatiempoImpl();
        DaoTurno daoTurno = new DaoTurnoImpl();

        List<Genero> generos = daoGenero.generoRadBtn();
        List<Pasatiempo> pasatiempos = daoPasatiempo.pasatiempoCheBox();
        List<Turno> turnos = daoTurno.turnoSelOp();

        if (generos != null && pasatiempos != null && turnos != null) {
            // Enviamos la lista de 'Generos', 'Turnos' y 'Pasatiempos'
            request.setAttribute("generos", generos);
            request.setAttribute("pasatiempos", pasatiempos);
            request.setAttribute("turnos", turnos);
        } else {
            result = daoEstudiante.getMessage();
        }
        return result;
    }

    public String estudianteInsUpd(boolean upd) {
        StringBuilder result = new StringBuilder("<ul style=\"list-style-type: none;\">");

        String idEstudianteAuz = request.getParameter("idEstudiante");
        Integer idEstudiante = null;
        if (idEstudianteAuz != null && !idEstudianteAuz.isEmpty()) {
            idEstudiante = Integer.valueOf(idEstudianteAuz);
        }
        if (upd && idEstudiante == null) {
            result.append("<li>Id requerido</li>");
        }

        String nombre = request.getParameter("nombre");
        if (nombre == null || nombre.trim().length() == 0) {
            result.append("<li>Nombre requerido</li>");
        } else if (nombre.trim().length() < 3 || nombre.trim().length() > 50) {
            result.append("<li>La dimensión del nombre debe estar entre")
                    .append("3 a 50 caracteres</li>");
        }

        String apellido = request.getParameter("apellido");
        if (apellido == null || apellido.trim().length() == 0) {
            result.append("<li>Apellido requerido</li>");
        } else if (apellido.trim().length() < 3 || apellido.trim().length() > 50) {
            result.append("<li>La dimensión del apellido debe estar entre")
                    .append("3 a 50 caracteres</li>");
        }

        String fechaNacimientoAux = request.getParameter("fecha-nacimiento");
        LocalDate fechaNacimiento = null;
        if (fechaNacimientoAux != null && !fechaNacimientoAux.isEmpty()) {
            fechaNacimiento = LocalDate.parse(fechaNacimientoAux);
        }
        if (fechaNacimiento == null) {
            result.append("<li>Fecha requerida</li>");
        } else if (fechaNacimiento.isAfter(LocalDate.now())) {
            result.append("<li>La fecha de nacimiento no puede ser en el futuro</li>");
        }

        String nDocumentoIdentidad = request.getParameter("documento-identidad");
        if (nDocumentoIdentidad == null || nDocumentoIdentidad.trim().isEmpty()) {
            result.append("<li>Documento de identidad requerido</li>");
        } else if (!nDocumentoIdentidad.matches("\\d+")) {
            result.append("<li>El documento de identidad debe contener solo números</li>");
        } else if (nDocumentoIdentidad.length() < 8) {
            result.append("<li>El documento de identidad debe tener al menos 8 dígitos</li>");
        }

        String correo = request.getParameter("correo");
        if (correo == null || correo.trim().isEmpty()) {
            result.append("<li>Correo requerido</li>");
        } else if (!correo.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            result.append("<li>Correo inválido</li>");
        }

        Part filePart = null;
        try {
            filePart = request.getPart("imagen-perfil");
        } catch (ServletException | IOException e) {
            result.append("<li>Error al procesar el archivo</li>");
        }

        if (filePart == null || filePart.getSize() == 0) {
            result.append("<li>Ingrese el archivo</li>");
        } else {
            // Tamaño de archivo restringido a 1.5 MB
            long sizeInBytes = filePart.getSize();
            double sizeInMB = (double) sizeInBytes / (1024 * 1024);
            if (sizeInMB > 1.5) {
                result.append("<li>El archivo supera el límite de tamaño de 1.5 MB</li>");
            }

            // Extensiones permitidas
            String contentType = filePart.getContentType();
            if (!contentType.equalsIgnoreCase("image/jpeg")
                    && !contentType.equalsIgnoreCase("image/png")
                    && !contentType.equalsIgnoreCase("image/jpg")) {
                result.append("<li>El archivo no es una imagen válida. Solo se permiten imágenes JPEG, PNG y JPG.</li>");
            }
        }

        String pesoAux = request.getParameter("peso");
        Double peso = null;
        if (pesoAux == null || pesoAux.trim().isEmpty()) {
            result.append("<li>Peso requerido</li>");
        } else {
            peso = Double.valueOf(pesoAux);
            if (peso <= 0 || peso > 300) {
                result.append("<li>El peso debe estar entre 0 y 300kg</li>");
            }
        }

        String alturaAux = request.getParameter("altura");
        Double altura = null;
        if (alturaAux == null || alturaAux.trim().isEmpty()) {
            result.append("<li>Altura requerida</li>");
        } else {
            altura = Double.valueOf(alturaAux);
            if (altura <= 0 || altura > 2.5) {
                result.append("<li>La altura debe estar entre 0 y 2.5 metros</li>");
            }
        }

        String generoAux = request.getParameter("genero");
        Integer genero = null;
        if (generoAux == null || generoAux.trim().isEmpty()) {
            result.append("<li>Género requerido</li>");
        } else {
            genero = Integer.valueOf(generoAux);
            if (genero <= 0) {
                result.append("<li>Id de género inválido</li>");
            }
        }

        String[] pasatiemposAux = request.getParameterValues("pasatiempo");
        List<Integer> pasatiemposSelec = new ArrayList<>();
        if (pasatiemposAux == null || pasatiemposAux.length == 0) {
            result.append("<li>Al menos un pasatiempo requerido</li>");
        } else {
            for (String pasatiempoAux : pasatiemposAux) {
                Integer pasatiempo = Integer.valueOf(pasatiempoAux);
                if (pasatiempo <= 0) {
                    result.append("<li>Id de pasatiempo inválido: " + pasatiempo + "</li>");
                } else {
                    pasatiemposSelec.add(pasatiempo);
                }
            }
        }

        String turnoAux = request.getParameter("turno");
        Integer turno = null;
        if (turnoAux == null || turnoAux.trim().isEmpty()) {
            result.append("<li>Turno requerido</li>");
        } else {
            turno = Integer.valueOf(turnoAux);
            if (turno <= 0) {
                result.append("<li>Id de turno inválido</li>");
            }
        }

        String estado;
        LocalDateTime fechaRegistro = null;

        if (!upd) {
            // Si es INS, establece los valores por defecto
            fechaRegistro = LocalDateTime.now();
            estado = "Activo";
        } else {
            // Si es UPD, recupera el estado desde la solicitud
            estado = request.getParameter("estado");
            if (estado == null || (!estado.equalsIgnoreCase("Activo") && !estado.equalsIgnoreCase("Inactivo"))) {
                result.append("<li>Estado inválido. Debe ser 'Activo' o 'Inactivo'</li>");
            }
        }

        Estudiante estudiante = new Estudiante();
        estudiante.setIdEstudiante(idEstudiante);
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setFechaNacimiento(fechaNacimiento);
        estudiante.setnDocumentoIdentidad(nDocumentoIdentidad);
        estudiante.setCorreo(correo);
        estudiante.setPeso(peso);
        estudiante.setAltura(altura);
        estudiante.setGenero(genero);

        List<EstudPasat> estudiantePasatiempos = new ArrayList<>();
        for (Integer pasatiempoId : pasatiemposSelec) {
            EstudPasat estudiantePasatiempo = new EstudPasat();
            estudiantePasatiempo.setEstudiante(idEstudiante);
            estudiantePasatiempo.setPasatiempo(pasatiempoId);
            estudiantePasatiempos.add(estudiantePasatiempo);
        }
        estudiante.setPasatiempos(estudiantePasatiempos);

        estudiante.setTurno(turno);
        estudiante.setEstado(estado);

        byte[] imagenPerfil = null;
        if (filePart != null && filePart.getSize() > 0) {
            try {
                InputStream fileContent = filePart.getInputStream();
                imagenPerfil = new byte[(int) filePart.getSize()];
                fileContent.read(imagenPerfil);
            } catch (IOException e) {
                result.append("<li>Error al leer el archivo</li>");
            }
        }
        estudiante.setImagenPerfil(imagenPerfil);

        if (!upd) {
            estudiante.setFechaRegistro(fechaRegistro);
        }

        if (result.length() == 35) {
            String msg = upd
                    ? daoEstudiante.estudianteUpd(estudiante)
                    : daoEstudiante.estudianteIns(estudiante);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }

        if (filePart != null && filePart.getSize() > 0 && result.length() > 35) {
            result.append("<li>Por favor, seleccione el archivo de nuevo.</li>");
        }

        //Si ocurre un error, se vuelve a cargar los valores
        DaoGenero daoGenero = new DaoGeneroImpl();
        List<Genero> generos = daoGenero.generoRadBtn();

        DaoPasatiempo daoPasatiempo = new DaoPasatiempoImpl();
        List<Pasatiempo> pasatiempos = daoPasatiempo.pasatiempoCheBox();

        DaoTurno daoTurno = new DaoTurnoImpl();
        List<Turno> turnos = daoTurno.turnoSelOp();

        if (result.length() > 35) {
            request.setAttribute("estudiante", estudiante);

            request.setAttribute("generos", generos);
            request.setAttribute("pasatiempos", pasatiempos);
            request.setAttribute("turnos", turnos);

            // Devuelve los pasatiempos seleccionados al usuario
            request.setAttribute("pasatiemposSelec", pasatiemposSelec);
        }
        return result.length() == 35 ? null : result.append("</ul>").toString();
    }
}
