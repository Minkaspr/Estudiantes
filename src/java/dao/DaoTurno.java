
package dao;

import entity.Turno;
import java.util.List;

public interface DaoTurno {
    // Para llenar los Select Options
    List<Turno> turnoSelOp();
    String getMessage();
}
