package com.example.Gerenciadordetarefas.Repository;

import com.example.Gerenciadordetarefas.Model.StatusModel;
import com.example.Gerenciadordetarefas.Model.TarefasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TarefaRepository extends JpaRepository<TarefasModel,Integer> {

    public List<TarefasModel> findAllByTitulotarefaContainingIgnoreCase (String titulotarefa);

    public List<TarefasModel> findByPrazoconclusaoContaining(LocalDate prazoconclusao);

}
