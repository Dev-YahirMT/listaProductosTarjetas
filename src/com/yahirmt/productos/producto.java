package com.yahirmt.productos;

public class producto implements Comparable<producto>{
    private double valor;
    private String descripcion;

    public producto(double valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "producto{" +
                "valor=" + valor +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public int compareTo(producto otroProducto) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(otroProducto.valor));
    }
}
