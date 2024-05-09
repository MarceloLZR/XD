package edu.aed.cap16bicicleta;

public class BNodo {
    private Bicicleta elemento;
    private BNodo siguiente;

    public BNodo(Bicicleta elemento, BNodo siguiente) {
        this.elemento = elemento;
        this.siguiente = siguiente;
    }
    
     public BNodo(Bicicleta elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
  
  
    public void setElemento(Bicicleta elemento) {
        this.elemento = elemento;
    }

    public void setSiguiente(BNodo siguiente) {
        this.siguiente = siguiente;
    }

    public Bicicleta getElemento() {
        return elemento;
    }

    public BNodo getSiguiente() {
        return siguiente;
    }
    
    
    
    
}
