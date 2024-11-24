package com.yahirmt.tarjeta;

import com.yahirmt.productos.producto;

import java.util.ArrayList;
import java.util.List;

public class tarjetaCredito {
    private double saldo = 1000;
    private List<producto> listaDeProductos;

    public tarjetaCredito(double limite){
        this.saldo = limite;
        this.listaDeProductos = new ArrayList<>();
    }

    public List<producto> getListaDeProductos() {
        return listaDeProductos;
    }

    public int numeroProductos(){
        return listaDeProductos.size();
    }

    public boolean lazarCompra(producto producto){
        if(this.saldo>= producto.getValor()){
          this.saldo-= producto.getValor();
          listaDeProductos.add(producto);
          return true;
        }
        else
            return false;
    }
    public boolean deleteCompra(int indice){
        listaDeProductos.remove(indice);
        return true;
    }

    public double getSaldo() {
        return saldo;
    }
}
