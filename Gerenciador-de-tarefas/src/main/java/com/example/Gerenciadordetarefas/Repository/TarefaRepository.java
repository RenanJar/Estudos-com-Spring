package com.example.Gerenciadordetarefas.Repository;

import com.example.Gerenciadordetarefas.Model.TarefasModel;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<TarefasModel,Integer> {

    public List<TarefasModel> findAllByTitulotarefaContainingIgnoreCase (String titulotarefa);

    public List<TarefasModel> findByPrazoconclusaoContaining(LocalDate prazoconclusao);

}
