package org.mateus.crud.model;

import java.util.UUID;

/***
 * Essa classe representa uma pessoa com nome, idade, email e cidade, também será gerado um ID aleatório.
 */
public class Pessoa {
    private String id;
    private String nome;
    private int idade;
    private String email;
    private String cidade;

    /***
     * Construtor para inicialização, os parâmetros deverão ser inserido quando a classe for instanciada, porém,
     * o ID será gerado automaticamente de forma aleatória.
     *
     * @param nome
     * @param idade
     * @param email
     * @param cidade
     */
    public Pessoa(String nome, int idade, String email, String cidade) {
        this.id = idGenerator();
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cidade = cidade;
    }
    public Pessoa() {}

    /***
     * Método para geração de ID aleatório.
     *
     * @return O ID da pessoa que será um UUID tipo 4 (gerado de forma pseudo aleatória).
     */
    private String idGenerator() {
        UUID idTwo = UUID.randomUUID();
        return idTwo.toString();
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

    /***
     * Retorna uma representação textual do objeto Pessoa usando como base o formato JSON.
     *
     * @return String representativa do objeto.
     */
    @Override
    public String toString() {
        return """
               {"id": "%s", "nome": "%s", "idade": "%d", "email": "%s", "cidade": "%s"},""".formatted(id, nome, idade, email, cidade);
    }
}
