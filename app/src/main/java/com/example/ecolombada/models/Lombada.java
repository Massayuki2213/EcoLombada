package com.example.ecolombada.models;

import java.io.Serializable;

public class Lombada implements Serializable {
    private String nome;
    private String cidade;
    private String endereco;
    private int[] veiculosPorDia;
    private int[] energiaPorDia;

    public Lombada(String nome, String cidade, String endereco, int[] veiculosPorDia, int[] energiaPorDia) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
        this.veiculosPorDia = veiculosPorDia;
        this.energiaPorDia = energiaPorDia;
    }

    public String getNome() { return nome; }
    public String getCidade() { return cidade; }
    public String getEndereco() { return endereco; }
    public int[] getVeiculosPorDia() { return veiculosPorDia; }
    public int[] getEnergiaPorDia() { return energiaPorDia; }

    public String getCidadeEndereco() {
        return cidade + " - " + endereco;
    }
}