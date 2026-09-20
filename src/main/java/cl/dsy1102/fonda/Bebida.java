package cl.dsy1102.fonda;

public abstract class Bebida {
    private String nombre;
    private int volumenML;
    private int stock;

    public Bebida(String nombre, int volumenML, int stock) {
        this.nombre=nombre;
        this.volumenML=volumenML;
        this.stock=stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getVolumenML() {
        return volumenML;
    }
    public void setVolumenML(int volumenML) {
        this.volumenML = volumenML;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public abstract double calcularPrecio();
    public abstract String obtenerDetalle();



}

