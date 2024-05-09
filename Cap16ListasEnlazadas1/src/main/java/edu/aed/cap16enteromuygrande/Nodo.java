package edu.aed.cap16enteromuygrande;

public class Nodo {
    //Numero de digitos a almacenar en un bloque
    private static final short DIGITOS_MAX=3;
    private static final short VALOR_MAX=1000;
    private short valor;
    private Nodo siguiente;
    public Nodo(){
        this("0");
    }
    public Nodo(String str){
        this(Short.parseShort(str));
    }
    public Nodo(short val){
        valor=val;
        siguiente=null;
    }

    public void setValor(short valor) {
        this.valor = valor;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public static short getDIGITOS_MAX() {
        return DIGITOS_MAX;
    }

    public static short getVALOR_MAX() {
        return VALOR_MAX;
    }
    
    
    public short getValor() {
        return valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
    
    
}
