package com.example.ecolombada.models;

public class Lombada {
    private String nome;
    private String endereco;

    public Lombada(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }
}