package com.lista2.exercicio1.service;

import com.lista2.exercicio1.models.Tarefa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    public List<Tarefa> tarefas = new ArrayList<>();

    public List<Tarefa> listarTarefa() {

        return tarefas;

    }

    public void cadastrarTarefa(Tarefa tarefa) {

        tarefas.add(tarefa);

    }

    public void update(Integer codigo, Tarefa tarefa) {

        cadastrarTarefa(tarefa);
        remover(codigo);

    }

    public Tarefa pesquisarTarefa(Integer codigo) {

        return tarefas.stream().filter(c -> codigo.equals(c.getCodigo())).findFirst().orElseThrow();

    }

    public void remover(Integer codigo) {
        Tarefa tarefaPesquisa = pesquisarTarefa(codigo);
        if (tarefaPesquisa != null) {
            tarefas.remove(tarefaPesquisa);

        }
    }
}
