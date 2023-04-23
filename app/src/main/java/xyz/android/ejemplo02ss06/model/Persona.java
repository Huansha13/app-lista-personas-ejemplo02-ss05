package xyz.android.ejemplo02ss06.model;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private int edad;
    private String perfil;

    public Persona(String nombre, int edad, String perfil) {
        this.nombre = nombre;
        this.edad = edad;
        this.perfil =  perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
