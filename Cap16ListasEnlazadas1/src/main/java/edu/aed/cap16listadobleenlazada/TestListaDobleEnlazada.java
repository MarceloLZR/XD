package edu.aed.cap16listadobleenlazada;

import java.util.Scanner;

public class TestListaDobleEnlazada {
     public static void main(String[] args) {
         ListaDobleEnlazada lista=new ListaDobleEnlazada();
         Scanner escaner=new Scanner(System.in);
         int num;
         System.out.println("Ingrese los valores numericos a la lista");
         num=escaner.nextInt();
         lista.insertarFinal(num);
         while(true){
             num=escaner.nextInt();
             if(num<=0) break;
             lista.insertarFinal(num);             
         }
         lista.imprimirNodos();
         System.out.println("Ingrese el valor a eliminar");
         num=escaner.nextInt();
         lista.eliminar(num);
         lista.imprimirNodos();
     }
}
