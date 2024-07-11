package org.mateus.crud;

import org.mateus.crud.model.Pessoa;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello and welcome!");
    Pessoa pessoa = new Pessoa("João", 40, "joaogrilo@gmail.com", "São Bernardo");
    System.out.println(pessoa.toString());
  }
}
