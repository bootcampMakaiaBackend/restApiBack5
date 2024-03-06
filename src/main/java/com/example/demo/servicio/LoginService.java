package com.example.demo.servicio;

import com.example.demo.modelo.Login;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class LoginService {


    public String authenticateUser(Login login) throws AuthenticationException {

        // login es nulo
        if(login.getUser().equals("") || login.getPassword().equals("")){
            //Como lanzo una exception?
            throw new AuthenticationException("Invalid username or password");
        }
        if(login.getUser().equals("admin") && login.getPassword().equals("password")) {
            return "Estas logeado";
        }
        throw new AuthenticationException("Invalid username or password");
    }
}
