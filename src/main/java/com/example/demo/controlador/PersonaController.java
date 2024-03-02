package com.example.demo.controlador;

import com.example.demo.modelo.Persona;
import com.example.demo.servicio.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    private PersonaService personaService;

    public PersonaController() {
        this.personaService = new PersonaService();
    }

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
}
