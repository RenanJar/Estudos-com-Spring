package com.example.Gerenciadordetarefas.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name= "statusdb")
public class StatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @NotNull
    @Column
    private String etiqueta;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("status")
    private List<TarefasModel> tarefaslist;

}
