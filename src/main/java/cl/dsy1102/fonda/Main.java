package cl.dsy1102.fonda;

import java.util.List;

/**
 * Punto de entrada de la Tarea Fiestas Patrias - Fonda San Belarmino.
 *
 * Revisa el enunciado en README.md. Debes crear, en este mismo paquete,
 * las clases del diagrama: Bebida, BebidaAlcoholica, BebidaSinAlcohol,
 * la interfaz ConsumoResponsable y la clase GestorFonda.
 */
public class Main {

    public static void main(String[] args) {
        BebidaAlcoholica chichaAlcoholica = new BebidaAlcoholica("Chicha", 1000, 40, 12.0, false);
        BebidaAlcoholica piscoSour = new BebidaAlcoholica("Pisco Sour", 500, 25, 18.0, true);
        BebidaSinAlcohol chichaSinAlcohol = new BebidaSinAlcohol("Chicha", 1000, 60, 95);
        BebidaSinAlcohol moteConHuesillo = new BebidaSinAlcohol("Mote Con Huesillo", 400, 50, 70);

        chichaAlcoholica.restringirVenta();

        GestorFonda gestor = new GestorFonda();
        gestor.registrar(chichaAlcoholica);
        gestor.registrar(piscoSour);
        gestor.registrar(chichaSinAlcohol);
        gestor.registrar(moteConHuesillo);

        gestor.vender("Pisco Sour", 2);
        gestor.vender("Pisco Sour", 5);
        gestor.vender("Chicha", 1);
        gestor.vender("Mote Con Huesillo", 6);

        System.out.println();
        System.out.println("===BUSQUEDA POR NOMBRE: \"Chicha\"===");

        List<Bebida> resultado = gestor.buscarPorNombre("Chicha");
        for (Bebida b : resultado) {
            System.out.println(b.obtenerDetalle());
            System.out.println("---");

        }
        System.out.println();
        System.out.println("===LISTADO DE BEBIDAS===");

        List<Bebida> todas = gestor.obtenerTodas();
        for (Bebida b : todas) {
            System.out.println(b);
        }
    }
}
