package com.example.Gerenciadordetarefas.Service;

import com.example.Gerenciadordetarefas.Model.UsuarioModel;
import com.example.Gerenciadordetarefas.Repository.UsuarioRepository;
import com.example.Gerenciadordetarefas.Seguranca.UserDetailsSeguranca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetailsSeguranca loadUserByUsername(String userName){
        Optional<UsuarioModel> user= userRepository.findByUsuario(userName);
        user.orElseThrow(()->new UsernameNotFoundException(userName + "not found."));

        return user.map(UserDetailsSeguranca::new).get();
    }
}
