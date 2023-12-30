
package test;

import dao.DaoPasatiempo;
import dao.impl.DaoPasatiempoImpl;
import entity.Pasatiempo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDaoPasatiempo {

    private static final Logger logger = Logger.getLogger(TestDaoPasatiempo.class.getName());

    public static void main(String[] args) {
        // Creamos un objeto DaoPasatiempo
        DaoPasatiempo daoPasatiempo = new DaoPasatiempoImpl();
        
        mostrarPasatiempos(daoPasatiempo);
    }

    public static void mostrarPasatiempos(DaoPasatiempo daoPasatiempo) {
        // Llamamos al método pasatiempoCheBox() para obtener la lista de pasatiempos
        List<Pasatiempo> list = daoPasatiempo.pasatiempoCheBox();
        if (list != null) {
            // Iteramos sobre cada elemento de la lista y mostramos los datos de cada pasatiempo
            for (Pasatiempo pasatiempo : list) {
                System.out.println(pasatiempo.getIdPasatiempo().toString() + " "
                        + pasatiempo.getPasatiempo());
            }
        } else {
            // Registramos el mensaje de la excepción en los logs
            logger.log(Level.SEVERE, "Error: " + daoPasatiempo.getMessage());
        }
    }
}
