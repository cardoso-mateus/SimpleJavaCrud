package org.mateus.crud.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mateus.crud.model.Pessoa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/***
 * Essa classe contém os métodos de serviço para fazer registro, leitura, atualização e exclusão de uma lista de pessoas.
 */
public class PessoaService {
    private final String FILE_PATH = "pessoas.txt";
    private final Path path = Paths.get(FILE_PATH);
    ObjectMapper mapper = new ObjectMapper();

    /***
     * Este método recebe uma referência do tipo Pessoa para fazer o registro em um arquivo texto.
     *
     * @param pessoa
     */
    public void registrarPessoa(Pessoa pessoa, boolean bool) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, bool))) {
            writer.write(pessoa.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao registrar pessoa: " + e.getMessage());
        }
    }

    /***
     * Este método utiliza uma lista carregada de pessoas e escreve essa lista no console.
     */
    public void listarPessoa() {
        try {
            carregarPessoas().forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /***
     * Este método carrega uma lista de pessoas, compara a ID da pessoa recebida pelo parâmetros e reescreve a lista de
     * pessoas com exceção da pessoa que possui o ID passado no parâmetro.
     *
     * @param id
     */
    public void deletarPessoa(String id) {
        try {
            List<Pessoa> novaLista = new ArrayList<>();
            for (Pessoa pessoa : carregarPessoas()) {
                if (!pessoa.getId().equals(id)) {
                    novaLista.add(pessoa);
                }
            }
            sobrescrevePessoas(novaLista);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * Método acessório.
     * Este método lê todas as linhas do arquivo de texto que lista as pessoas e retorna um objeto List<Pessoa>, o processo
     * é feito usando desserialização de JSON.
     *
     * @return List<Pessoa>
     * @throws Exception
     */
    private List<Pessoa> carregarPessoas() throws Exception {
        StringBuilder builder = new StringBuilder();
        try {
            String conteudo = Files.readString(path);
            conteudo = conteudo.substring(0, conteudo.length() - 3);
            builder.append("[%s]".formatted(conteudo));
            String jsonFormatado = builder.toString();
            var listaPessoas = mapper.readValue(jsonFormatado, new TypeReference<List<Pessoa>>(){});
            return listaPessoas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /***
     * Método acessório.
     * Este método é utilizado para reescrever a lista de pessoas no arquivo de texto quando uma pessoa da lista é deletada.
     *
     * @param pessoa
     */
    private void sobrescrevePessoas(List<Pessoa> pessoa) {
        try {
            registrarPessoa(pessoa.get(0), false);
            for (int i = 1; i < pessoa.size(); i++) {
                registrarPessoa(pessoa.get(i), true);
            }
        } catch (Exception e) {
            System.err.println("Erro ao registrar pessoa: " + e.getMessage());
        }
    }
}
