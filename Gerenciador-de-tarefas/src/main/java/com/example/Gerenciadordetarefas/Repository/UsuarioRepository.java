package com.example.Gerenciadordetarefas.Repository;

import com.example.Gerenciadordetarefas.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    public Optional<UsuarioModel>findByUsuario(String usuario);


}
