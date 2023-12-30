
package test;

import dao.DaoTurno;
import dao.impl.DaoTurnoImpl;
import entity.Turno;
import java.util.List;
import java.util.Scanner;

public class TestDaoTurno {

    public static void main(String[] args) {

        Scanner scanner;
        // Creamos un objeto DaoTurno
        DaoTurno daoTurno = new DaoTurnoImpl();
        Integer opt;
        do {
            scanner = new Scanner(System.in);
            inicio();
            opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    mostrarTurnos(daoTurno);
                    break;
                case 2:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opt != 2);
    }

    private static void inicio() {
        System.out.println("\n--------Claves de las prueba-----");
        System.out.println("1: Lista de turnos - turnoSelOp");
        System.out.println("2: Salir");
        System.out.println("-----------------------------------");
        System.out.print("\nIngrese la clave: ");
    }

    /**
     * Este método muestra la información de todos los turnos.
     *
     * @param daoTurno Un objeto DaoTurno para acceder a los datos de los
     * turnos.
     */
    public static void mostrarTurnos(DaoTurno daoTurno) {
        // Creamos una lista para almacenar los resultados
        // Llamamos al método turnoSelOp() para obtener la lista de turnos
        List<Turno> list = daoTurno.turnoSelOp();
        if (list != null) {
            try {
                // Iteramos sobre cada elemento de la lista y mostramos los datos de cada turno
                list.forEach(turno -> {
                    System.out.println(turno.getIdTurno().toString() + " "
                            + turno.getTurno());
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            // Imprimimos el mensaje de la excepción en la consola
            System.out.println("Error: " + daoTurno.getMessage());
        }
    }
}
