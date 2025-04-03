package com.example.desenrola;

public class Produto {
    private int id;
    private String nome;
    private String marca;

    public Produto(int id, String nome, String marca) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getMarca() { return marca; }
}
