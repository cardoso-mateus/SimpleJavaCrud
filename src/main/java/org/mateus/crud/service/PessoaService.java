package org.mateus.crud.service;

import org.mateus.crud.model.Pessoa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/***
 * Essa classe contém os métodos de serviço para fazer registro, leitura, atualização e exclusão de uma lista de pessoas.
 */
public class PessoaService {
    private static final String FILE_PATH = "pessoas.txt";

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

    /***
     * Este método faz a leitura do arquivo texto onde serão registradas as pessoas.
     */
    public void listarPessoas() {
        Path path = Paths.get(FILE_PATH);
        if ( Files.exists(path)) {
            try {
                Files.lines(path).forEach(System.out::println);
            } catch (IOException e) {
                System.err.println("Erro ao ler arquivo de pessoas: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhuma pessoa registrada ainda.");
        }
    }
}
