package org.mateus.crud;

import java.util.Scanner;
import org.mateus.crud.model.Pessoa;
import org.mateus.crud.service.PessoaService;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    PessoaService pessoaService = new PessoaService();
    int opcao = 0;

    String tela = """
                  ***********************
                  Banco de dados incrivelmente simples!
                  Escolha uma opção:
                  Opção 1: registrar uma pessoa;
                  Opção 2: listar pessoas registradas;
                  Opção 3: deletar uma pessoa;
                  Opção 4: sair.
                  ***********************
                  """;
    System.out.println(tela);
    System.out.print("Insira uma opção: ");

    while (opcao != 4) {
      opcao = input.nextInt();
      input.nextLine();

      switch (opcao) {
        case 1:
          System.out.print("Insira o nome: ");
          String nome = input.nextLine();
          System.out.print("Insira o idade: ");
          int idade = input.nextInt();
          input.nextLine();
          System.out.print("Insira o email: ");
          String email = input.nextLine();
          System.out.print("Insira o cidade: ");
          String cidade = input.nextLine();
          Pessoa pessoa = new Pessoa(nome, idade, email, cidade);
          pessoaService.registrarPessoa(pessoa, true);
          System.out.println("Pessoa registrada com sucesso.");
          System.out.println(tela);
          break;
        case 2:
          pessoaService.listarPessoa();
          System.out.println(tela);
          break;
        case 3:
          System.out.println("Insira o ID da pessoa a ser deletada: ");
          String id = input.nextLine();
          pessoaService.deletarPessoa(id);
          System.out.println("Pessoa deletada com sucesso!");
          System.out.println(tela);
          break;
        case 4:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida, digite uma opção entre 1 e 4.");
      }
    }
    input.close();
  }
}
