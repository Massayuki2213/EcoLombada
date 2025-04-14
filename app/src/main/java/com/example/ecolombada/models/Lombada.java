package com.example.ecolombada.models;

public class Lombada {
    private String nome;
    private String cidade;
    private String endereco;

    public Lombada(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidadeEndereco() {
        return cidade + " - " + endereco;
    }
}