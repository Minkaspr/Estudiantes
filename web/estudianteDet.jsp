<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle del Estudiante</title>
        <link rel="icon" href="assets/Sencillo.png">
        <link rel="stylesheet" href="css/view.css">
    </head>
    <body>
        <div class="container glass">
            <div class="header">
                <h2 class="title">Perfil del Estudiante</h2>
                <div class="back">
                    <a href="Estudiante?op=SEL" class="btn-icon">
                        <img class="icon" src="assets/user-back.svg" alt="atras">
                        Atras
                    </a>
                </div>
            </div>
            <div class="shift">
                <span>Turno</span>
                <img class="icon-shift" src="
                     <c:choose>
                         <c:when test="${estudianteDTO.turno eq 'Mañana'}">assets/shift-sunrise.svg</c:when>
                         <c:when test="${estudianteDTO.turno eq 'Tarde'}">assets/shift-sun.svg</c:when>
                         <c:otherwise>assets/shift-night.svg</c:otherwise>
                     </c:choose>
                         " alt="${estudianteDTO.turno}">
                <span style="font-size: 14px">${estudianteDTO.turno}</span>
            </div>
            <div class="main">
                <div class="img-profile">
                    <img class="img" src="data:image/*;base64,${estudianteDTO.imagenPerfilBase64}">
                </div>
                <div class="data-profile">
                    <p class="data-name">${estudianteDTO.nombre} ${estudianteDTO.apellido}</p>
                    <p class="data-email">${estudianteDTO.correo}</p>
                </div>
                <div class="data-details">
                    <div class="sub-title"><h3>Detalles</h3></div>

                    <div class="description">
                        <span class="description-title">N° Documento de Identidad</span>    
                        <div class="description-info">
                            <img class="icon-details" src="assets/ic-id-card.svg" alt="numero de identidad">
                            <p class="description-text">${estudianteDTO.nDocumentoIdentidad}</p>
                        </div>
                    </div>

                    <div class="description">
                        <span class="description-title">Fecha de nacimiento</span>    
                        <div class="description-info">
                            <img class="icon-details" src="assets/ic-date.svg" alt="fecha de nacimiento">
                            <p class="description-text">${estudianteDTO.fechaNacimiento}</p>
                        </div>
                    </div>

                    <div class="group-cols">
                        <div class="description">
                            <span class="description-title">Altura</span>    
                            <div class="description-info">
                                <img class="icon-details" src="assets/ic-arrow-fit-height.svg" alt="altura">
                                <p class="description-text">${estudianteDTO.altura} cm</p>
                            </div>
                        </div>

                        <div class="description">
                            <span class="description-title">Peso</span>    
                            <div class="description-info">
                                <img class="icon-details" src="assets/ic-weight.svg" alt="peso">
                                <p class="description-text">${estudianteDTO.peso} KG</p>
                            </div>
                        </div>

                        <div class="description">
                            <span class="description-title">Género</span>    
                            <div class="description-info">
                                <img class="icon-details" src="assets/ic-gender-mark.svg" alt="genero">
                                <p class="description-text">${estudianteDTO.genero}</p>
                            </div>
                        </div>
                    </div>
                    <div class="hobbies">
                        <span class="description-title">Pasatiempos</span>    
                        <div class="description-info hobb">
                            <img class="icon-details" src="assets/ic-square-poll-horizontal.svg" alt="pasatiempos">
                            <ul class="description-text">
                                <c:forEach var="pasatiempo" items="${estudianteDTO.pasatiempos}">
                                    <li>${pasatiempo}</li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="description">
                        <span class="description-title">Fecha Registro</span>    
                        <div class="description-info">
                            <img class="icon-details" src="assets/ic-date-time.svg" alt="fecha de registro">
                            <p class="description-text">${estudianteDTO.fechaRegistro}</p>
                        </div>
                    </div>
                    <div class="description">
                        <span class="description-title">Estado</span>    
                        <div class="description-info">
                            <img class="icon-details" src="assets/ic-calendar-user.svg" alt="estado">
                            <p class="description-text">${estudianteDTO.estado}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
