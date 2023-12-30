
package dao;

import entity.Pasatiempo;
import java.util.List;

public interface DaoPasatiempo {
    // Para llenar los Check Boxes
    List<Pasatiempo> pasatiempoCheBox();
    String getMessage();
}
