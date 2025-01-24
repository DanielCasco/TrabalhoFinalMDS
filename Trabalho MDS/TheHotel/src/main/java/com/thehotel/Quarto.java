package com.thehotel;

import java.util.ArrayList;
import java.util.List;

public class Quarto {
    private int id;
    private int capacidade;
    private int numCamas;
    private String tipoVista;
    private boolean cozinha;
    private int numWC;
    private boolean varanda;
    private boolean disponivel;
    private List<Manutencao> manutencoes;

    public Quarto(int id, int capacidade, int numCamas, String tipoVista, boolean cozinha, int numWC, boolean varanda) {
        this.id = id;
        this.capacidade = capacidade;
        this.numCamas = numCamas;
        this.tipoVista = tipoVista;
        this.cozinha = cozinha;
        this.numWC = numWC;
        this.varanda = varanda;
        this.disponivel = true;
        this.manutencoes = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Quarto[id=" + id + ", capacidade=" + capacidade + ", camas=" + numCamas +
                ", vista=" + tipoVista + ", cozinha=" + cozinha + 
                ", banheiros=" + numWC + ", varanda=" + varanda + 
                ", disponível=" + disponivel + "]";
    }


    public boolean verificarDisponibilidade() {
        return disponivel;
    }

    public static void criarQuarto(Quarto quarto) {
        System.out.println("Quarto criado: " + quarto);
    }

    public static void removerQuarto(Quarto quarto) {
        System.out.println("Quarto removido: " + quarto);
    }
 
    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    public String getTipoVista() {
        return tipoVista;
    }

    public void setTipoVista(String tipoVista) {
        this.tipoVista = tipoVista;
    }

    public boolean isCozinha() {
        return cozinha;
    }

    public void setCozinha(boolean cozinha) {
        this.cozinha = cozinha;
    }

    public int getNumWC() {
        return numWC;
    }

    public void setNumWC(int numWC) {
        this.numWC = numWC;
    }

    public boolean isVaranda() {
        return varanda;
    }

    public void setVaranda(boolean varanda) {
        this.varanda = varanda;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Manutencao> getManutencoes() {
        return manutencoes;
    }

    public void setManutencoes(List<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
    }
}

