package edu.aed.cap16bicicleta;

public class Bicicleta {
    private String nomPropietario;

    public Bicicleta(String nombre) {
        setNomPropietario(nombre);
    }

    public void setNomPropietario(String nomPropietario) {
        this.nomPropietario = nomPropietario;
    }

    public String getNomPropietario() {
        return nomPropietario;
    }
    
}
