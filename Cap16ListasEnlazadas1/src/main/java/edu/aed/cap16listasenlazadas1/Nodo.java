package edu.aed.cap16listasenlazadas1;

public class Nodo {
    private int elemento;
    private Nodo siguiente;

    public Nodo(){
        this(0,null);
    }
    public Nodo(int elemento, Nodo siguiente) {
        setElemento(elemento);
        setSiguiente(siguiente);       
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public int getElemento() {
        return elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
    
    
    
    
}
