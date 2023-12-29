
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
                <h2 class="title">Nuevo Estudiante</h2>
                <div class="back">
                    <a href="#" class="btn-icon">
                        <img class="icon" src="assets/user-back.svg" alt="atras">
                        Atras
                    </a>
                </div>
            </div>

            <div class="main">
                <form action="">
                    <div class="group-imputs">
                        <div class="imput">
                            <label for="nombre">Nombre:</label>
                            <input type="text" id="nombre" name="nombre" placeholder="Ingrese su nombre">
                        </div>
                        <div class="imput">
                            <label for="apellido">Apellido:</label>
                            <input type="text" id="apellido" name="apellido" placeholder="Ingrese su apellido">
                        </div>
                        <div class="imput">
                            <label for="fecha-nacimiento">Fecha de Nacimiento:</label>
                            <input type="date" id="fecha-nacimiento" name="fecha-nacimiento">
                        </div>
                        <div class="imput">
                            <label for="documento-identidad">N° Documento de Identidad:</label>
                            <input type="text" id="documento-identidad" name="documento-identidad"
                                   placeholder="Ingrese su número de documento de identidad">
                        </div>
                        <div class="imput">
                            <label for="correo">Correo:</label>
                            <input type="email" id="correo" name="correo" placeholder="Ingrese su correo">
                        </div>
                        <div class="imput">
                            <label for="imagen-perfil">Subir Imagen de Perfil:</label>
                            <button type="button" class="contenedor-btn-file">
                                <label for="imagen-perfil">
                                    <img class="icon" src="assets/user-file-search.svg" alt="file">
                                    Adjuntar archivo
                                </label>
                                <input type="file" id="imagen-perfil" name="imagen-perfil">
                            </button>
                        </div>
                        <div class="imput">
                            <label for="peso">Peso:</label>
                            <input type="number" id="peso" name="peso" placeholder="Ingrese su peso">
                        </div>
                        <div class="imput">
                            <label for="altura">Altura:</label>
                            <input type="number" id="altura" name="altura" placeholder="Ingrese su altura">
                        </div>
                        <div class="imput">
                            <label for="genero">Género:</label>
                            <div class="dropdown">
                                <div class="select">
                                    <span class="selected">Masculino</span>
                                    <div class="caret"></div>
                                </div>
                                <ul class="menu">
                                    <li class="active">Masculino</li>
                                    <li>Femenino</li>
                                    <li>Otro</li>
                                </ul>
                            </div>
                        </div>                    
                    </div>
                    <div class="group-select">
                        <div class="radius">
                            <label for="hobbies">Hobbies:</label>
                            <div class="checkboxes">
                                <div class="checkbox-sub_group">
                                    <input type="checkbox" id="cantar" name="hobbies" value="cantar">
                                    <label for="cantar">Cantar</label>
                                </div>
                                <div class="checkbox-sub_group">
                                    <input type="checkbox" id="dibujar" name="hobbies" value="dibujar">
                                    <label for="dibujar">Dibujar</label>
                                </div>
                                <div class="checkbox-sub_group">
                                    <input type="checkbox" id="bailar" name="hobbies" value="bailar">
                                    <label for="bailar">Bailar</label>
                                </div>
                                <div class="checkbox-sub_group">
                                    <input type="checkbox" id="leer" name="hobbies" value="leer">
                                    <label for="leer">Leer</label>
                                </div>
                            </div>
                        </div>
                        <div class="checkbox">
                            <label for="turno">Turno:</label>
                            <div class="radiobuttons">
                                <div class="radiobutton-sub_group">
                                    <input type="radio" id="manana" name="turno" value="manana">
                                    <label for="manana">Mañana</label>
                                </div>
                                <div class="radiobutton-sub_group">
                                    <input type="radio" id="tarde" name="turno" value="tarde">
                                    <label for="tarde">Tarde</label>
                                </div>
                                <div class="radiobutton-sub_group">
                                    <input type="radio" id="noche" name="turno" value="noche">
                                    <label for="noche">Noche</label>
                                </div>
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
        <script src="js/addEdit.js"></script>
    </body>
</html>
