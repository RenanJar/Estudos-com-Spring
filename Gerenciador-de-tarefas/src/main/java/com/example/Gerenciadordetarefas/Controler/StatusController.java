package com.example.Gerenciadordetarefas.Controler;

import com.example.Gerenciadordetarefas.Model.StatusModel;
import com.example.Gerenciadordetarefas.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class StatusController {

    @Autowired
    private StatusRepository repository;

    @GetMapping
    public ResponseEntity<List<StatusModel>>GetALL(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<StatusModel>GetbyID(@PathVariable int id){
        return repository.findById(id).map(resp-> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StatusModel>create(@RequestBody StatusModel criarstatus){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(repository.save(criarstatus));
    }

    @PutMapping
    public ResponseEntity<StatusModel>Update(@RequestBody StatusModel updatestatus){
        return ResponseEntity.ok(repository.save(updatestatus));

    }

    @DeleteMapping("/{id}")
    public void Delete (@PathVariable int id){
        repository.deleteById(id);
    }

}
