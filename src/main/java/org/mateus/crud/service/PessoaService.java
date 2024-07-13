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
    public void registrarPessoas(Pessoa pessoa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(pessoa.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao registrar pessoa: " + e.getMessage());
        }
    }

    public void listarPessoas() {
        try {
            carregarPessoas().forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

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
}
