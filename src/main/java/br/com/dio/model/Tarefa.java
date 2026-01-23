package br.com.dio.model;

public class Tarefa {
    private int id;
    private String nome;
    private String status;

    public Tarefa(int id, String nome, String status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getStatus() { return status; }
}