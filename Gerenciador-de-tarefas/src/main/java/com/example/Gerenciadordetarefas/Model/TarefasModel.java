package com.example.Gerenciadordetarefas.Model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="Tarefas")
public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave primaria
    private int idtarefa;

    @NotBlank
    @Size(min=5, max=100)
    private String titulotarefa;

    @NotBlank
    @Size(min=5,max=400)
    private String descriçãotarefa;

    @NotNull
    private LocalDate prazoconclusao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datapostagem = new java.sql.Date(System.currentTimeMillis());

    //precisa arrumar pois, nao pode ser requisito na hora de criação de uma tarefa
    private Integer status;

}
