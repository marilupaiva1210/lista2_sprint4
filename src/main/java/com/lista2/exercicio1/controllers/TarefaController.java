package com.lista2.exercicio1.controllers;

import com.lista2.exercicio1.models.Tarefa;
import com.lista2.exercicio1.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TarefaController {
    @Autowired
    private TarefaService service;

    @GetMapping(value = "/tarefa")
    public ResponseEntity listar() {

        return new ResponseEntity(service.listarTarefa(), HttpStatus.OK);

    }

    @GetMapping(value = "/tarefa/{codigo}")
    public ResponseEntity listarPorCodigo(@PathVariable Integer codigo) {

        return new ResponseEntity(service.pesquisarTarefa(codigo), HttpStatus.OK);

    }


    @PostMapping(value = "/tarefa/cadastro")
    public ResponseEntity cadastrarTarefa(@RequestBody Tarefa tarefa) {

        service.cadastrarTarefa(tarefa);
        return new ResponseEntity("cadastrado com sucesso!", HttpStatus.CREATED);

    }

    @PutMapping(value = "/tarefa/{codigo}")
    public ResponseEntity alterar(@PathVariable Integer codigo, @RequestBody Tarefa tarefa) {

        service.update(codigo, tarefa);
        return new ResponseEntity(tarefa, HttpStatus.OK);

    }

    @DeleteMapping(value = "/tarefa/{codigo}")
    public ResponseEntity deletarTarefa(@PathVariable Integer codigo) {

        service.remover(codigo);
        return new ResponseEntity("tarefa do código " + codigo + " foi removida! ",HttpStatus.OK);

    }
}
