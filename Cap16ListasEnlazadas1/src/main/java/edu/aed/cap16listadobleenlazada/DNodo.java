package edu.aed.cap16listadobleenlazada;

public class DNodo {
    private int elemento;
    private DNodo siguiente;
    private DNodo anterior;

    public DNodo(int elemento, DNodo siguiente, DNodo anterior) {
        this.elemento = elemento;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    
    public DNodo(int elemento){
        this.elemento = elemento;
        this.siguiente = null;
        this.anterior = null;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public void setSiguiente(DNodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(DNodo anterior) {
        this.anterior = anterior;
    }

    public int getElemento() {
        return elemento;
    }

    public DNodo getSiguiente() {
        return siguiente;
    }

    public DNodo getAnterior() {
        return anterior;
    }
    
    
    
}
