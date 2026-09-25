package cl.dsy1102.fonda;

public abstract class Bebida {
    private String nombre;
    private int volumenML;
    private int stock;
//constructor
    public Bebida(String nombre, int volumenML, int stock) {
       setNombre(nombre);
       setVolumenML(volumenML);
       setStock(stock);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public int getVolumenML() {
        return volumenML;
    }

    public void setVolumenML(int volumenML) {
        if (volumenML < 100 || volumenML > 3000) {
            throw new IllegalArgumentException("El volumen esta fuera de rango");
        }
        this.volumenML = volumenML;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        if (stock <= 0) {
            throw new IllegalArgumentException("El stock debe ser mayor a 0");
        }
        this.stock = stock;
    }

    public abstract double calcularPrecio();
    public abstract String obtenerDetalle();

    @Override
    public String toString() {
        return nombre + "-" + volumenML + "ml";
    }

}

