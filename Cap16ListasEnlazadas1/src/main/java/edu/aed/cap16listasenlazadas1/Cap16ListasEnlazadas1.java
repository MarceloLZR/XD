package edu.aed.cap16listasenlazadas1;
import java.util.Scanner;
public class Cap16ListasEnlazadas1 {
    public static void main(String[] args) {
        Scanner escaner=new Scanner(System.in);
        Nodo inicio,prev,rem;
        int num;
        inicio=null;
        System.out.println("Ingreso de valores de la lista enlazada");
        while(true){
            num=escaner.nextInt();
            if(num<=0) break;            
            inicio=new Nodo(num,inicio);
        }           
        //visualizando la lista enlazada
        Nodo actual;
        actual=inicio;
        while(actual!=null){
            System.out.print(actual.getElemento()+" ,");
            actual=actual.getSiguiente();            
        }        
        System.out.println("Ingreso el valor a eliminar");
        num=escaner.nextInt();
        rem=inicio;
        prev=null;
        while(rem!=null && num!=rem.getElemento()){
            prev=rem;
            rem=rem.getSiguiente();
        }
        if(rem==null)
            System.out.println("Nodo buscado no existe");
        else{
            if(rem==inicio)
                inicio=inicio.getSiguiente();
            else
                prev.setSiguiente(rem.getSiguiente());
        }
        
        //visualizando la lista enlazada        
        actual=inicio;
        while(actual!=null){
            System.out.print(actual.getElemento()+" ,");
            actual=actual.getSiguiente();            
        }  
        
    }
    
    public void testListaEnlazada1(){
        Nodo uno,dos,tres;
        uno=new Nodo(45,null);
        dos=new Nodo(98,null);
        tres=new Nodo(23,null);
        uno.setSiguiente(dos);
        dos.setSiguiente(tres);
        
        //visualizando la lista enlazada
        Nodo actual;
        actual=uno;
        while(actual!=null){
            System.out.print(actual.getElemento()+" ,");
            actual=actual.getSiguiente();            
        }
        
    }
    public void testVariacion1(){
         Scanner escaner=new Scanner(System.in);
        Nodo inicio,cola,siguiente;
        inicio=null;
        System.out.println("Ingreso de valores de la lista enlazada");
        int num=escaner.nextInt();
        if(num>0){
            inicio=new Nodo(num,null);
            cola=inicio;
            while(true){
                num=escaner.nextInt();
                if(num<=0)break;
                siguiente=new Nodo(num,null);
                cola.setSiguiente(siguiente);
                cola=siguiente;
            }
        }
        //visualizando la lista enlazada
        Nodo actual;
        actual=inicio;
        while(actual!=null){
            System.out.print(actual.getElemento()+" ,");
            actual=actual.getSiguiente();            
        }
    }
    public void testVariacion2(){
        Scanner escaner=new Scanner(System.in);
        Nodo inicio,cola,siguiente;
        inicio=null;
        System.out.println("Ingreso de valores de la lista enlazada");
        int num=escaner.nextInt();
        if(num>0){
            inicio=new Nodo(num,null);
            cola=inicio;
            while(true){
                num=escaner.nextInt();
                if(num<=0)break;                
                cola.setSiguiente(new Nodo(num,null));
                cola=cola.getSiguiente();
            }
        }
        //visualizando la lista enlazada
        Nodo actual;
        actual=inicio;
        while(actual!=null){
            System.out.print(actual.getElemento()+" ,");
            actual=actual.getSiguiente();            
        }
        
    }
    public void testVariacion3(){
         Scanner escaner=new Scanner(System.in);
        Nodo inicio,cola;
        inicio=new Nodo(0,null);
        cola=inicio;
        while(true){
            int num=escaner.nextInt();
            if(num<=0)break;
            cola.setSiguiente(new Nodo(num,null));
            cola=cola.getSiguiente();            
        }
        inicio=inicio.getSiguiente();
        //visualizando la lista enlazada
        Nodo actual;
        actual=inicio;
        while(actual!=null){
            System.out.print(actual.getElemento()+" ,");
            actual=actual.getSiguiente();            
        }
    }
    public void testVariacion4(){
         Scanner escaner=new Scanner(System.in);
        Nodo inicio,temp;
        inicio=null;
        System.out.println("Ingreso de valores de la lista enlazada");
        while(true){
            int num=escaner.nextInt();
            if(num<=0) break;
            temp=inicio;
            inicio=new Nodo(num,temp);
        }        
        //visualizando la lista enlazada
        Nodo actual;
        actual=inicio;
        while(actual!=null){
            System.out.print(actual.getElemento()+" ,");
            actual=actual.getSiguiente();            
        }
    }
}
