package edu.aed.cap16listadobleenlazada;

public class ListaDobleEnlazada {
    DNodo primero;
    DNodo ultimo;
    //constructor que inicializa los nodos en nulo
    public ListaDobleEnlazada() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public void insertarFinal(int valor){
        DNodo nuevoNodo=new DNodo(valor);
        if(ultimo==null){
            primero=nuevoNodo;
            ultimo=nuevoNodo;
        }else{
            nuevoNodo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevoNodo);
            ultimo=nuevoNodo;
        }
    }
    
    public void insertarInicio(int valor){
        DNodo nuevoNodo=new DNodo(valor);
        if(ultimo==null){
            primero=nuevoNodo;
            ultimo=nuevoNodo;
        }else{
            nuevoNodo.setSiguiente(primero);
            primero.setAnterior(nuevoNodo);
            primero=nuevoNodo;
        }
    }    
    public void eliminar(int valor){
        DNodo actual=primero;
        while(actual!=null && actual.getElemento()!=valor){
            actual=actual.getSiguiente();
        }
        if(actual!=null){//encontro el valor que buscaba
            if(actual==primero){
                primero=actual.getSiguiente();
                if(primero!=null)
                    primero.setAnterior(null);
                else
                    ultimo=null;
            }else if(actual==ultimo){
                ultimo=actual.getAnterior();
                ultimo.setSiguiente(null);
            }else{
                actual.getAnterior().setSiguiente(actual.getSiguiente());
                actual.getSiguiente().setAnterior(actual.getAnterior());
            }
        }
    }
    
    public void imprimir(){
        DNodo actual=primero;
        while(actual!=null){
            System.out.println(actual.getElemento() + " ");
            actual=actual.getSiguiente();
        }
        System.out.println(" ");
    }
    
    public void imprimirNodos(){
        DNodo actual=primero;
        while(actual!=null){
            if(actual.getAnterior()==null)
                System.out.println("nodo: " + actual.getElemento() + " nodo anterior:Ninguno, nodo siguiente: "+actual.getSiguiente().getElemento());
            else if(actual.getSiguiente()==null)
                System.out.println("nodo: " + actual.getElemento() + " nodo anterior:" +actual.getAnterior().getElemento() +" nodo siguiente:Fin");
            else
                System.out.println("nodo: " + actual.getElemento() + " nodo anterior: " +actual.getAnterior().getElemento() +" nodo siguiente: "+actual.getSiguiente().getElemento());
            actual=actual.getSiguiente();
        }
        
    }
    
    
}
