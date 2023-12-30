
package test;

import dao.DaoGenero;
import dao.impl.DaoGeneroImpl;
import entity.Genero;
import java.util.List;
import java.util.Scanner;

public class TestDaoGenero {

    public static void main(String[] args) {

        Scanner scanner;
        // Creamos un objeto DaoGenero
        DaoGenero daoGenero = new DaoGeneroImpl();
        Integer opt;
        do {
            scanner = new Scanner(System.in);
            inicio();
            opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    mostrarGeneros(daoGenero);
                    break;
                case 0:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opt != 0);
    }

    private static void inicio() {
        System.out.println("--------Claves de las prueba-----");
        System.out.println("1: Lista de géneros generoRadBtn");
        System.out.println("0: Salir");
        System.out.println("-----------------------------------");
        System.out.print("\nIngrese la clave: ");
    }

    /**
     * Este método muestra la información de todos los géneros.
     *
     * @param daoGenero Un objeto DaoGenero para acceder a los datos de
     * los géneros.
     */
    public static void mostrarGeneros(DaoGenero daoGenero) {
        // Creamos una lista para almacenar los resultados
        // Llamamos al método generoRadBtn() para obtener la lista de géneros
        List<Genero> list = daoGenero.generoRadBtn();
        if (list != null) {
            try {
                // Iteramos sobre cada elemento de la lista y mostramos los datos de cada género
                list.forEach(genero -> {
                    System.out.println(genero.getIdGenero().toString() + " "
                            + genero.getGenero());
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            // Imprimimos el mensaje de la excepción en la consola
            System.out.println("Error: " + daoGenero.getMessage());
        }
    }
}

