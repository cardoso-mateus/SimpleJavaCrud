package org.mateus.crud;

import org.mateus.crud.model.Pessoa;
import org.mateus.crud.service.PessoaService;

import java.util.Scanner;

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
                  Opção 3: sair.
                  ***********************
                  """;
    System.out.println(tela);
    System.out.print("Insira uma opção: ");

    while (opcao != 3) {
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
          pessoaService.registrarPessoas(pessoa);
          System.out.println("Pessoa registrada com sucesso.");
          System.out.println(tela);
          break;
        case 2:
          pessoaService.listarPessoas();
          System.out.println(tela);
          break;
        case 3:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida, digite uma opção entre 1 e 3.");
      }
    }
    input.close();
  }
}
