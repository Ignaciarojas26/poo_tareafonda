package cl.dsy1102.fonda;

public class BebidaAlcoholica extends Bebida implements ConsumoResponsable {
    public static final int LIMITE_UNIDADES_POR_CLIENTE = 3;
    private double gradosAlcohol;
    private boolean certificada;
    private boolean ventaRestringida;
    //este no esta en el constructor porque no viene como parametro

    public BebidaAlcoholica(String nombre, int volumenML, int stock, double gradosAlcohol, boolean certificada) {
        super(nombre, volumenML, stock);
        setGradosAlcohol(gradosAlcohol);
        this.certificada = certificada;
        this.ventaRestringida = false;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }
    public void setGradosAlcohol (double gradosAlcohol) {
        if (gradosAlcohol < 0.5 || gradosAlcohol > 45) {
            throw new IllegalArgumentException("Los grados de alcohol deben estar en un rango de 0,5 a 45");
        }
        this.gradosAlcohol=gradosAlcohol;
    }

    public boolean isCertificada() {
        return certificada;
    }
    public void setCertificada(boolean certificada) {
        this.certificada = certificada;
    }

    //aqui se traen a los metodos de la interfaz
    @Override
    public boolean tieneVentaRestringida() {
        return ventaRestringida;
    }

    @Override
    public void restringirVenta() {
        ventaRestringida = true;
    }
    @Override
    public boolean superaLimite(int unidades){
        return unidades >= LIMITE_UNIDADES_POR_CLIENTE;
    }
    @Override
    public double calcularPrecio() {
        double precioBase = 3500;

        if (!isCertificada()) { //cuando no esta certificada aumenta el precio el 20%
            precioBase = precioBase * 1.20;
        }
        return precioBase;
    }

    @Override
    public String obtenerDetalle() {
        return "Tipo: Bebida Alcoholica | Nombre: " + getNombre() + " | Volumen: " + getVolumenML() + " ml" + " | Stock: " + getStock()
                + " | Grados: " + gradosAlcohol + " | Certificada: " + (isCertificada() ? "Sí" : "No") +
                " | Venta restringida: " + (tieneVentaRestringida() ? "Si" : "No")+ " | Precio: $" + calcularPrecio();
    }

}
