package com.example.Gerenciadordetarefas.Controler;

import ch.qos.logback.classic.Level;
import com.example.Gerenciadordetarefas.Model.TarefasModel;
import com.example.Gerenciadordetarefas.Repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin("*")
public class TarefaController {

    @Autowired                          ///injeção de dependendia pois a classe e uma interface nao sendo possivel instacia-la
    private TarefaRepository repository;

    @GetMapping
    public ResponseEntity<List<TarefasModel>> GetALL(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefasModel> GetdbyID(@PathVariable int id){
        return repository.findById(id).map(resp-> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/consultaprazo")
    public List<TarefasModel> GetbyDate(@RequestParam String prazo){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date =LocalDate.parse(prazo,formatter);
        System.out.println(date);
        return repository.findByPrazoconclusaoContaining(date);
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<TarefasModel>>GetbyTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(repository.findAllByTitulotarefaContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<TarefasModel>Create(@RequestBody TarefasModel criartarefas){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(criartarefas));
    }

    @PutMapping
    public ResponseEntity<TarefasModel>Update(@RequestBody TarefasModel editartarefas){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(editartarefas));

    }

    @DeleteMapping("/{id}")
    public void Delete (@PathVariable int id){
        repository.deleteById(id);
    }




/*
    @GetMapping("/consultaprazo")
    public List<TarefasModel>GetbyDate(@RequestParam LocalDate prazoconclusao){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        prazoconclusao.parse(prazoconclusao.toString(), formatter);
        return repository.findByPrazoconclusaoContaining(prazoconclusao);
    }


 */

}
