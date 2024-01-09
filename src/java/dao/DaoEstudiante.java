
package dao;

import dto.EstudianteDTO;
import entity.Estudiante;
import java.util.List;

public interface DaoEstudiante {
    List<EstudianteDTO> estudianteSel(); // View
    EstudianteDTO estudianteDet(Integer id); // Details
    Estudiante estudianteGet(Integer id);
    String estudianteIns(Estudiante estudiante);
    String estudianteUpd(Estudiante estudiante);
    String estudianteDel(List<Integer> ids);
    List<EstudianteDTO> estudianteSrch(String buscar); // View - Search
    String getMessage();
}
