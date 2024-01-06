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
                    <div class="search">
                        <input class="search-right" type="text" placeholder="Buscar">
                        <a href="#" class="search-left"><img class="icon" src="assets/user-search.svg" alt="Buscar"></a>
                    </div>
                    <a href="#" class="refresh"><img class="icon" src="assets/user-refresh.svg" alt="Refrescar"></a>
                </div>
            </div>
            <div class="header-bottom">
                <a href="#" class="item-bottom"><img class="icon" src="assets/user-delete.svg" alt="Eliminar"></a>
                <a href="Estudiante?op=DF" class="item-bottom"><img class="icon" src="assets/user-add.svg" alt="Agregar"></a>
            </div>
            <div class="table">
                <table class="table-container">
                    <thead>
                        <tr>
                            <th colspan="1">Seleccionar</th>
                            <th colspan="4">Contacto</th>
                            <th colspan="1">Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="estudiante" items="${estudiantes}">
                            <tr>
                                <td>
                                    <div class="table-checkbox"><input type="checkbox"></div>
                                </td>
                                <td colspan="4">
                                    <div class="table-data">
                                        <div class="img-profile">
                                            <img class="img" src="data:image/jpeg;base64,${estudiante.imagenPerfilBase64}">
                                        </div>
                                        <div class="data-profile">
                                            <p class="data">${estudiante.nombre} ${estudiante.apellido}</p>
                                            <p class="data">${estudiante.correo}</p>
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
    </body>
</html>
