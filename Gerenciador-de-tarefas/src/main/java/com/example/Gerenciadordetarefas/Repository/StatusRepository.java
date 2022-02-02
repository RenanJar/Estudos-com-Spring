package com.example.Gerenciadordetarefas.Repository;

import com.example.Gerenciadordetarefas.Model.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StatusRepository extends JpaRepository<StatusModel, Integer> {
    public List<StatusModel> findAllByEtiquetaContainingIgnoreCase(String etiqueta);

}
