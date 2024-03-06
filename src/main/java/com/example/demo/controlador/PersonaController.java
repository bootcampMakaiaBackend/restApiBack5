package com.example.demo.controlador;

import com.example.demo.modelo.Persona;
import com.example.demo.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    private PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

//Inyectar las dependencias


    //localhost:8080/personas -> get
    @GetMapping("/personas/") //get
    public List<Persona> obtenerPersonas(){
        return this.personaService.obtenerPersonas();
    }

    @GetMapping("/personas/{cedula}")
    public Persona obtenerPersonaPorCedula(@PathVariable("cedula") String cedula) {
        return this.personaService.obtenerPersonaPorCedula(cedula);
    }

    @DeleteMapping("/personas/{cedula}")
    public void eliminarPersona(@PathVariable("cedula") String cedula){
        this.personaService.eliminarPersona(cedula);
    }

    @PostMapping("/personas/")
    public Persona agregarPersona(@RequestBody Persona persona){
        return this.personaService.crearPersona(persona);
    }
    //localhost:8080/personas?ciudad=Medellin&departamento=Antiquia
    @GetMapping("/personas")
    public List<Persona> obtenerPersonaPorCiudad(@RequestParam("ciudad") String ciudad){
        return this.personaService.obtenerPersonaPorCiudad(ciudad);
    }

    //crear un endpoint que me filtre por ciudad , edad de las personas
    //crear un endpoint que  elimine por ciudad
}
