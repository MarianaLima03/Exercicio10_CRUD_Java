package com.GR._0.controllers;

import com.GR._0.models.TarefaModel;
import com.GR._0.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel) {
        TarefaModel request = tarefaService.criarTarefa(tarefaModel);

        // CORREÇÃO AQUI: estava "/livros/"
        URI uri = URI.create("/tarefa/" + request.getId());
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<TarefaModel>> listarTarefa() {
        List<TarefaModel> request = tarefaService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TarefaModel>> buscarIdTarefa(@PathVariable Long id) {
        Optional<TarefaModel> request = tarefaService.buscarIdTarefa(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}