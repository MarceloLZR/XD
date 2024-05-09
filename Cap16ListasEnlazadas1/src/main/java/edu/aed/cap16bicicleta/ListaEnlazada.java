package edu.aed.cap16bicicleta;

public class ListaEnlazada {
    BNodo primero;
    BNodo ultimo;
    //constructor que inicializa los nodos en nulo
    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public void insertarFinal(Bicicleta valor){
        BNodo nuevoNodo=new BNodo(valor);
        if(ultimo==null){
            primero=nuevoNodo;
            ultimo=nuevoNodo;
        }else{           
            ultimo.setSiguiente(nuevoNodo);
            ultimo=nuevoNodo;
        }
    }
    
    public void insertarInicio(Bicicleta valor){
        BNodo nuevoNodo=new BNodo(valor);
        if(ultimo==null){
            primero=nuevoNodo;
            ultimo=nuevoNodo;
        }else{
            nuevoNodo.setSiguiente(primero);            
            primero=nuevoNodo;
        }
    }    
    
    
    public void imprimir(){
        BNodo actual=primero;
        while(actual!=null){
            System.out.println(actual.getElemento().getNomPropietario() + " ");
            actual=actual.getSiguiente();
        }
        System.out.println(" ");
    }
    
    public void imprimirNodos(){
        BNodo actual=primero;
        while(actual!=null){           
            if(actual.getSiguiente()==null)
                System.out.println("nodo: " + actual.getElemento().getNomPropietario() + " nodo siguiente:Fin");
            else
                System.out.println("nodo: " + actual.getElemento().getNomPropietario() + " nodo siguiente: "+actual.getSiguiente().getElemento().getNomPropietario());
            actual=actual.getSiguiente();
        }
        
    }
    
}
