package edu.aed.cap16listaenlazadacircular;

import java.util.Scanner;

public class TestListaEnlazadaCircular {
    public static void main(String[] args) {
        ListaEnlazadaCircular lista =new ListaEnlazadaCircular();
        Scanner escaner=new Scanner(System.in);
        int num;
        System.out.println("Ingrese los valores numericos a la lista enlazada: ");
        num=escaner.nextInt();
        lista.add(num);
        while(true){
            num=escaner.nextInt();
            if(num<=0) break;                
              lista.add(num);              
        }
        lista.printList();
        System.out.println("Ingrese el valor que desea eliminar de la lista enlazada: ");
        num=escaner.nextInt();
        lista.remove(num);
        lista.printList();
    }
}
