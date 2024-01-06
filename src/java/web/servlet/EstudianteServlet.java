package web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.validator.EstudianteValidator;

@WebServlet(name = "EstudianteServlet", urlPatterns = {"/Estudiante"})
public class EstudianteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String opcion = request.getParameter("op");
        opcion = (opcion == null) ? "" : opcion;

        String result = null;
        String target = "estudianteSel.jsp";

        EstudianteValidator validator = new EstudianteValidator(request);
        switch (opcion) {
            case "SEL":
                result = validator.estudianteSel();
                break;
            case "DF":
                result = validator.estudianteDf();
                target = "estudianteIns.jsp";
                break;
            case "INS":
                result = validator.estudianteInsUpd(false);
                target = result == null ? "Estudiante?op=SEL" : "estudianteIns.jsp";
                break;
            case "UPD":
                result = validator.estudianteInsUpd(true);
                target = result == null ? "Estudiante?op=SEL" : "mascotaUpd.jsp";
                break;
            case "":
                result = "Solicitud requerida";
                break;
            default:
                result = "Solicitud no reconocida";
        }

        if (result != null) {
            request.setAttribute("message", result);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
