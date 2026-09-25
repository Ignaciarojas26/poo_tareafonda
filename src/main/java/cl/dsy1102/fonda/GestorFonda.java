package cl.dsy1102.fonda;
import java.util.List;
import java.util.ArrayList;

public class GestorFonda {
    private List<Bebida> bebidas;

    public GestorFonda() {
        bebidas = new ArrayList<>();
    }

    public void registrar(Bebida bebida) {
        bebidas.add(bebida);
        System.out.println(bebida.getNombre() + " (" + bebida.getClass().getSimpleName() + ") registrada correctamente.");
    }
    public List<Bebida> buscarPorNombre(String nombre) {
        List<Bebida> encontradas = new ArrayList<>();

        for (Bebida b : bebidas) {
            if (b.getNombre().equals(nombre)) {
                encontradas.add(b);
            }
        }
        return encontradas;
    } //aqui se usa la interfaz para validar la venta
    public void vender(String nombre, int unidades) {
        List<Bebida> encontradas = buscarPorNombre(nombre);
        Bebida b = encontradas.get(0);

        if (b instanceof ConsumoResponsable) {
            ConsumoResponsable cr = (ConsumoResponsable) b;

            if (cr.tieneVentaRestringida()) {
                System.out.println("Venta rechazada: " + nombre + " tiene la venta restringida");
                return;
            }

            if (cr.superaLimite(unidades)) {
                System.out.println("Venta rechazada: " + unidades + " unidades de " + nombre + " superan el limite de 3 por cliente.");
                return; //sale del metodo directo
            }

        } //si pasa hasta aqui es porque paso todas las validaciones
        double total = unidades * b.calcularPrecio();
        System.out.println("Venta autorizada: " + unidades + "x" + nombre + " | Total: $" + total);
    }
    public List<Bebida> obtenerTodas() {
        return bebidas;
    }


}

