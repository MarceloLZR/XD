package edu.aed.cap16bicicleta;

import java.util.Scanner;

public class TestBicicleta {
    public static void main(String[] args) {
         ListaEnlazada lista=new ListaEnlazada();
         Scanner escaner=new Scanner(System.in);
         String nombre;
         System.out.println("Ingrese los valores para la lista");
         nombre=escaner.next();
         if(!nombre.equalsIgnoreCase("salir")){
            lista.insertarFinal(new Bicicleta(nombre));
            while(true){
               nombre=escaner.next();
               if(nombre.equalsIgnoreCase("salir")) break;
               lista.insertarFinal(new Bicicleta(nombre));
            }
         }
         lista.imprimirNodos();
         
    }  
    
}
