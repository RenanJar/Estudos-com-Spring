package com.example.Gerenciadordetarefas.Controler;

import com.example.Gerenciadordetarefas.Model.UserLoginModel;
import com.example.Gerenciadordetarefas.Model.UsuarioModel;
import com.example.Gerenciadordetarefas.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/logar")
    public ResponseEntity<UserLoginModel> Autentication(@RequestBody Optional<UserLoginModel> user) {
        return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioModel> Post(@RequestBody UsuarioModel usuario) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.CadastrarUsuario(usuario));
    }

}
