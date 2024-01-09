<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudiantes</title>
        <link rel="icon" href="assets/Sencillo.png">
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body>
        <div class="container glass">
            <div class="header-top">
                <h2 class="title">Estudiantes</h2>
                <div class="group">
                    <form action="Estudiante" method="post">
                        <div class="search">
                            <input type="hidden" name="op" value="SRCH"/>
                            <input class="search-right" type="text" placeholder="Buscar" name="buscar">
                            <button type="submit" class="search-left"><img class="icon" src="assets/user-search.svg" alt="Buscar"></button>
                        </div>
                    </form>
                    <a href="Estudiante?op=SEL" class="refresh"><img class="icon" src="assets/user-refresh.svg" alt="Refrescar"></a>
                </div>
            </div>
            <div class="header-bottom">
                <a href="#" onclick="estudiantesDel();" class="item-bottom"><img class="icon" src="assets/user-delete.svg" alt="Eliminar"></a>
                <a href="Estudiante?op=DF" class="item-bottom"><img class="icon" src="assets/user-add.svg" alt="Agregar"></a>
            </div>
            <div class="table">
                <table class="table-container">
                    <thead>
                        <tr>
                            <th colspan="1">Seleccionar</th>
                            <th colspan="4">Estudiantes</th>
                            <th colspan="1">Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="estudiante" items="${estudiantes}">
                            <tr>
                                <td>
                                    <div class="table-checkbox"><input type="checkbox" name="id_del" value="${estudiante.idEstudiante}"></div>
                                </td>
                                <td colspan="4">
                                    <div class="table-data">
                                        <div class="img-profile">
                                            <img class="img" src="data:image/*;base64,${estudiante.imagenPerfilBase64}" alt="Imagen de perfil">
                                        </div>
                                        <div class="data-profile">
                                            <p class="data">${estudiante.nombre} ${estudiante.apellido}</p>
                                            <p class="data">${estudiante.correo}</p>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <div class="table-operations">
                                        <a href="Estudiante?op=DET&idEstudiante=${estudiante.idEstudiante}" class="item-operations"><img class="icon" src="assets/user-question.svg" alt="Visualizar"></a>
                                        <a href="Estudiante?op=GET&idEstudiante=${estudiante.idEstudiante}" class="item-operations"><img class="icon" src="assets/user-edit.svg" alt="Editar"></a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>


                        <tr>
                            <td>
                                <div class="table-checkbox"><input type="checkbox"></div>
                            </td>
                            <td colspan="4">
                                <div class="table-data">
                                    <div class="img-profile">
                                        <img class="img" src="assets/user1.jpg">
                                    </div>
                                    <div class="data-profile">
                                        <p class="data">Julieta Torres Pereza</p>
                                        <p class="data">julieta@gmail.com</p>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="table-operations">
                                    <a href="estudianteDet.jsp" class="item-operations"><img class="icon" src="assets/user-question.svg" alt="Visualizar"></a>
                                    <a href="estudianteUpd.jsp" class="item-operations"><img class="icon" src="assets/user-edit.svg" alt="Editar"></a>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div class="table-checkbox"><input type="checkbox"></div>
                            </td>
                            <td colspan="4">
                                <div class="table-data">
                                    <div class="img-profile">
                                        <img class="img" src="assets/user2.jpg">
                                    </div>
                                    <div class="data-profile">
                                        <p class="data">Jose perez gutierrez</p>
                                        <p class="data">jose@gmail.com</p>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="table-operations">
                                    <a href="view.html" class="item-operations"><img class="icon" src="assets/user-question.svg" alt="Visualizar"></a>
                                    <a href="addEdit.html" class="item-operations"><img class="icon" src="assets/user-edit.svg" alt="Editar"></a>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
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
        <script>
            function estudiantesDel() {
                // Crea un arreglo vacío para almacenar los ids de los estudiantes a eliminar
                var ids = [];
                // Obtiene todos los checkboxes seleccionados y los agrega al arreglo de ids
                document.querySelectorAll("input[name='id_del']:checked").forEach(function (element) {
                    ids.push(element.value);
                });
                // Si no se ha seleccionado ningún checkbox
                if (ids.length === 0) {
                    // Muestra un mensaje de alerta
                    alert("Advertencia\n\nSeleccione la(s) fila(s) a Retirar");
                } else {
                    // Pregunta al usuario si está seguro de eliminar los registros seleccionados
                    var exito = confirm('¿Seguro que deseas borrar los registros?');
                    // Si el usuario confirma la eliminación
                    if (exito) {
                        // Redirige a la página de eliminación de estudiantes con los ids de los estudiantes a eliminar
                        window.location = "Estudiante?op=DEL&ids=" + ids.toString();
                    } else {
                        // Muestra un mensaje indicando que la operación fue cancelada
                        alert("Operación cancelada");
                    }
                }
            }
        </script>
    </body>
</html>
