import java.util.ArrayList;

public class Factura {
    private String fechaFactura;
    private int numeroFactura;
    private String cliente;
    private ArrayList<DetalleFactura> detallesFactura = new ArrayList<>();
    private double totalCalculadoFactura;

    // Métodos Getters y Setters
    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }

    public void agregarDetalle(DetalleFactura detalle) {
        this.detallesFactura.add(detalle);
    }

    public void calcularMontoTotal() {
        totalCalculadoFactura = 0;
        for (DetalleFactura detalle : detallesFactura) {
            totalCalculadoFactura += detalle.getSubtotal();
        }
    }

    public double getTotalCalculadoFactura() {
        return totalCalculadoFactura;
    }
}



