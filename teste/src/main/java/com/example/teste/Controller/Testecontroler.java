package com.example.teste.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Testecontroler {

    @GetMapping
    public String hello(){
        return "Ola mundo ! ! !";
    }
}
