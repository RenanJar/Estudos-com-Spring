package com.example.Gerenciadordetarefas.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name= "Tarefas")
public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave primaria
    @Column
    private int idtarefa;

    @NotBlank
    @Size(min=5, max=100)
    @Column
    private String titulotarefa;

    @NotBlank
    @Size(min=5,max=400)
    @Column
    private String descriçãotarefa;

    @NotNull
    @Column
    private LocalDate prazoconclusao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date datapostagem = new java.sql.Date(System.currentTimeMillis());

    @ManyToOne
    @JsonIgnoreProperties("tarefaslist")
    private StatusModel status;

}
