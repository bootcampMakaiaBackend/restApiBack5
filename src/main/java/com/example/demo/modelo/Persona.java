package com.example.demo.modelo;

public class Persona {
    private String cedula;
    private String nombre;
    private String apellido;
    private String ciudad;

    public Persona(String cedula, String nombre, String apellido, String ciudad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCiudad() {
        return ciudad;
    }
}
