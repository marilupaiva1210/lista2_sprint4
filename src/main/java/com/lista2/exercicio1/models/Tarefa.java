package com.lista2.exercicio1.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Tarefa {

        private Integer codigo;
        private String titulo;
        private String descricao;
        private LocalDate dataDeVencimento;

}


