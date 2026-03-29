package com.GR._0.services;

import com.GR._0.models.TarefaModel;
import com.GR._0.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaModel criarTarefa(TarefaModel tarefaModel) { return tarefaRepository.save(tarefaModel);
    }

    public List<TarefaModel> findAll() {
        return tarefaRepository.findAll();
    }

    public Optional<TarefaModel> buscarIdTarefa(Long id) {
        return tarefaRepository.findById(id);
    }

    public void deletarLivro(Long id) {
        tarefaRepository.deleteById(id);
    }

    public void deletarTarefa(Long id) {
    }
}

