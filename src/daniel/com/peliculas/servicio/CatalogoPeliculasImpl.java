/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daniel.com.peliculas.servicio;

import daniel.com.peliculas.datos.AccesoDatos;
import daniel.com.peliculas.datos.AccesoDatosImpl;
import daniel.com.peliculas.domain.Pelicula;
import daniel.com.peliculas.excepciones.AccesoDatosEx;


/**
 *
 * @author adseglocdom
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula : peliculas) {
                System.out.println("pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPeliculas(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalagPeliculas() {
        try {
            if (datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }

}
