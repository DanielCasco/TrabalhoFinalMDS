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

    public boolean verificarDisponibilidade() {
        return disponivel;
    }

    public void sugerirQuarto() {
        System.out.println("Sugestão de quarto: " + this);
    }

    
}
