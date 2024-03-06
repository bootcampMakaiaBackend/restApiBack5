package com.example.demo.controlador;

import com.example.demo.modelo.Login;
import com.example.demo.servicio.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
public class LoginController {

    private LoginService loginSergvice;

    @Autowired
    public LoginController(LoginService loginSergvice) {
        this.loginSergvice = loginSergvice;
    }

    @PostMapping("/login")
    public String login (@RequestBody Login login){
        try{
            //1 - para asegurar un codigo que pude lanzar una exception.
            return this.loginSergvice.authenticateUser(login);

            //cual es la posible exeption que puede lanzar esa porcion de codigo.
        } catch (AuthenticationException e) {
            // puedo enviar un correo
            // puedo lanzar otra exepcion
            // la manejo como quierp.
            return e.getMessage();
        }
    }

}
