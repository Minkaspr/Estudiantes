<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Estudiante</title>
        <link rel="icon" href="assets/Sencillo.png">
        <link rel="stylesheet" href="css/addEdit.css">
    </head>
    <body>
        <div class="container glass">
            <div class="header">
                <h2 class="title">Actualizar Estudiante</h2>
                <div class="back">
                    <a href="Estudiante?op=SEL" class="btn-icon">
                        <img class="icon" src="assets/user-back.svg" alt="atras">
                        Atras
                    </a>
                </div>
            </div>

            <div class="main">
                <form action="Estudiante" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="op" value="UPD"/>
                    <input type="hidden" name="idEstudiante" value="${estudiante.idEstudiante}"/>
                    <div class="group-imputs">
                        <div class="imput">
                            <label for="nombre">Nombre:</label>
                            <input type="text" id="nombre" name="nombre" placeholder="Ingrese su nombre" value="${estudiante.nombre}">
                        </div>

                        <div class="imput">
                            <label for="apellido">Apellido:</label>
                            <input type="text" id="apellido" name="apellido" placeholder="Ingrese su apellido" value="${estudiante.apellido}">
                        </div>

                        <div class="imput">
                            <label for="fecha-nacimiento">Fecha de Nacimiento:</label>
                            <input type="date" id="fecha-nacimiento" name="fecha-nacimiento" value="${estudiante.fechaNacimiento}">
                        </div>

                        <div class="imput">
                            <label for="documento-identidad">N° Documento de Identidad:</label>
                            <input type="text" id="documento-identidad" name="documento-identidad"
                                   placeholder="Ingrese su número de documento de identidad" value="${estudiante.nDocumentoIdentidad}">
                        </div>

                        <div class="imput">
                            <label for="correo">Correo:</label>
                            <input type="email" id="correo" name="correo" placeholder="Ingrese su correo" value="${estudiante.correo}">
                        </div>

                        <div class="imput">
                            <label for="imagen-perfil">Subir Imagen de Perfil:</label>
                            <input type="file" id="imagen-perfil" name="imagen-perfil">
                        </div>

                        <div class="imput">
                            <label for="peso">Peso:</label>
                            <input type="number" id="peso" name="peso" placeholder="Ingrese su peso" min="0.0" step="0.01" value="${estudiante.peso != null ? estudiante.peso : '0'}">
                        </div>

                        <div class="imput">
                            <label for="altura">Altura:</label>
                            <input type="number" id="altura" name="altura" placeholder="Ingrese su altura" min="0.0" step="0.01" value="${estudiante.altura != null ? estudiante.altura : '0'}">
                        </div> 

                        <div class="imput">
                            <label for="genero">Género:</label>
                            <select id="genero" name="genero">
                                <option disabled>Seleccionar</option>
                                <c:forEach var="g" items="${generos}">
                                    <option value="${g.idGenero}" <c:if test="${g.idGenero == estudiante.genero}">selected</c:if>>
                                        ${g.genero}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="imput">
                            <label for="estado">Estado:</label>
                            <select id="estado" name="estado">
                                <option value="" disabled>Seleccionar</option>
                                <option value="Activo" <c:if test="${estudiante.estado eq 'Activo'}">selected</c:if>>Activo</option>
                                <option value="Inactivo" <c:if test="${estudiante.estado eq 'Inactivo'}">selected</c:if>>Inactivo</option>
                            </select>
                        </div>
                    </div>
                    <div class="group-select">
                        <div class="checkbox">
                            <label for="hobbies">Pasatiempos:</label>
                            <div class="checkboxes">
                                <c:forEach var="p" items="${pasatiempos}">
                                    <div class="checkbox-sub_group">
                                        <input 
                                            type="checkbox" name="pasatiempo" 
                                            id="${p.pasatiempo}" value="${p.idPasatiempo}" 
                                            <c:if test="${pasatiemposSelec.contains(p.idPasatiempo)}">checked</c:if>
                                                >
                                            <label for="${p.pasatiempo}">${p.pasatiempo}</label>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                        <div class="radius">
                            <label for="turno">Turno:</label>
                            <div class="radiobuttons">
                                <c:forEach var="t" items="${turnos}">
                                    <div class="radiobutton-sub_group">
                                        <input 
                                            type="radio" name="turno" 
                                            id="${t.turno}" value="${t.idTurno}" 
                                            <c:if test="${t.idTurno == estudiante.turno}">checked</c:if>
                                                >
                                            <label for="${t.turno}">${t.turno}</label>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="button-container">
                        <button type="submit" class="btn">
                            <img class="icon" src="assets/user-check.svg" alt="atras">
                            Confirmar
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <c:if test="${message != null}">
            <div 
                 style="
                 position: absolute;
                 top: 64px;
                 right: 64px;
                 width: 320px;
                 background: rgba(255, 255, 255, .1);
                 backdrop-filter: blur(10px);
                 border: 1.5px solid rgba(255, 255, 255, .2);
                 border-radius: 16px;
                 padding: 16px;
                 "
                 >
                <h3>Corregir</h3>
                ${message}
            </div>
        </c:if>
    </body>
</html>
