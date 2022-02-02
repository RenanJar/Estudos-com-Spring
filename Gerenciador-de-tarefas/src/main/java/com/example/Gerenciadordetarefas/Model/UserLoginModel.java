package com.example.Gerenciadordetarefas.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class UserLoginModel {

    private String nome;

    private String usuario;

    private String senha;

    private String token;




}
