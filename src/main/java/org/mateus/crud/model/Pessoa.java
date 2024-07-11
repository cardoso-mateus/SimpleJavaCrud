package org.mateus.crud.model;

import java.util.UUID;

public class Pessoa {
    private String id;
    private String nome;
    private int idade;
    private String email;
    private String cidade;

    public Pessoa(String nome, int idade, String email, String cidade) {
        this.id = idGenerator();
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cidade = cidade;
    }

    private String idGenerator() {
        UUID idTwo = UUID.randomUUID();
        String id = String.valueOf(idTwo);
        return id;
    }

    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return """
               Pessoa {"id": "%s", "nome": "%s", "idade": "%d", "email": "%s", "cidade": "%s"}
               """.formatted(id, nome, idade, email, cidade);
    }
}
