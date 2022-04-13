/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daniel.com.peliculas.presentacion;

import daniel.com.peliculas.servicio.*;
import java.util.Scanner;

/**
 *
 * @author adseglocdom
 */
public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        while (opcion != 0) {
            System.out.println("Elige una opción: \n"
                    + "1. Iniciar catalogo peliculas \n"
                    + "2. Agregar pelicula \n"
                    + "3. Listar peliculas \n"
                    + "4. Buscar pelicula \n"
                    + "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalagPeliculas();
                    break;
                case 2:
                    System.out.println("Ingresa el nombre de la pelicula: ");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Ingresa el nombre de la pelicula: ");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPeliculas(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                     System.out.println("Opción no reconocida");
                    break;
            }
        }
    }

}
