public class Ingrediente {
    private String nombre;
    private double cantidad;
    private String unidadDemedida;

    public Ingrediente(String nombre, double cantidad, String unidadDemedida){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadDemedida = unidadDemedida;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUnidadDemedida() {
        return unidadDemedida;
    }

    public double getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", unidadDemedida='" + unidadDemedida + '\'' +
                '}';
    }
}
