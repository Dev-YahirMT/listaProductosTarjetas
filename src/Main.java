import com.yahirmt.productos.producto;
import com.yahirmt.tarjeta.tarjetaCredito;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el limite de la tarjeta:");
        double saldo = scanner.nextDouble();
        tarjetaCredito inicio = new tarjetaCredito(saldo);
        int opcion;
        do{
            System.out.println("Eligue un dato:");
            System.out.println("1 Agregar un producto");
            System.out.println("2 Eliminar un producto");
            System.out.println("3 Lista de productos");
            System.out.println("0 Finalizar Compra");
            opcion = scanner.nextInt();
            if(opcion==1){
                System.out.println("Escribe la descripcion del producto");
                String descripcion = scanner.next();

                System.out.println("Escribe el valor del producto");
                double valor = Double.valueOf(scanner.next());

                producto productoCompra = new producto(valor,descripcion);
                boolean CompraRealizada = inicio.lazarCompra(productoCompra);

                if (CompraRealizada){
                    System.out.println("Compra realizada");
                }else{
                    System.out.println("Saldo insuficiente");
                    opcion = 0;
                }

                System.out.println("-------------------------");
            } else if (opcion==2) {
                if (inicio.numeroProductos()==0){
                    System.out.println("No tienes productos que eliminar");
                    System.out.println("Numero de productos:"+inicio.numeroProductos());
                }else {
                    System.out.println("Numero de productos:"+inicio.numeroProductos());
                    System.out.println("-------------------------");
                    System.out.println("Eliminar producto");
                    int conteo = 1;
                    for (producto productoLista: inicio.getListaDeProductos()){
                        System.out.println(conteo+"--"+productoLista.getDescripcion()+"--"+productoLista.getValor());
                        conteo ++;
                    }
                    System.out.println("999 - Cancelar eliminacion");
                    int opcion2 = scanner.nextInt();
                    if (opcion2 == 999 || (opcion2>inicio.numeroProductos()))
                    {
                        System.out.println("No se cancelo ningun producto");
                    }else{
                        inicio.deleteCompra(opcion2-1);
                    }
                }

            } else if (opcion==3) {

                System.out.println("---------------------------");
                System.out.println("---------------------------");
                System.out.println("Lista de productos\n");

                for (producto productoLista: inicio.getListaDeProductos()){
                    System.out.println(productoLista.getDescripcion()+"--"+productoLista.getValor());
                }

                System.out.println(inicio.numeroProductos()+"\n");

            }
            System.out.println("---------------------------");
            System.out.println("---------------------------");
        }while(opcion!=0);

        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("COMPRA REALIZADA\n");
        Collections.sort(inicio.getListaDeProductos());
        for (producto productoLista: inicio.getListaDeProductos()){
            System.out.println(productoLista.getDescripcion()+"--"+productoLista.getValor());
        }

        System.out.println("---------------------------");
        System.out.println("\nSaldo en la tarjeta:"+ inicio.getSaldo());

    }
}