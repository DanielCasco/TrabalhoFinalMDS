package com.thehotel;

public class Funcionario extends Utilizador {
    private String cargo;
    private String credenciais;

    public Funcionario(int id, String nome, String email, String cargo) {
        super(id, nome, email);
        this.cargo = cargo;
        this.credenciais = credenciais;
    }
}