package com.example.Gerenciadordetarefas.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@Table(name="usuariotb")
public class UsuarioModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @Size(min=3,max=100)
    private String nome;


    @NotNull
    @Size(min=5,max=100)
    private String usuario;


    @NotNull
    @Size(min=5,max=100)
    private String senha;


}
