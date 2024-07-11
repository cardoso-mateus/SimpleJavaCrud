package org.mateus.crud.model;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private String email;
    private String cidade;

    public Pessoa(String nome, int idade, String email, String cidade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
               Pessoa {"id": "%d", "nome": "%s", "idade": "%d", "email": "%s", "cidade": "%s"}
               """.formatted(id, nome, idade, email, cidade);
    }
}
