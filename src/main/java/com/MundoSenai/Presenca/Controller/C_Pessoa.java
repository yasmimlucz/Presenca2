package com.MundoSenai.Presenca.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Pessoa {
    @GetMapping("/")
    public String helloWorld(){
        return "Login/login";
    }

    @GetMapping("/teste")
    public String teste(){
        return "teste";
    }

}
