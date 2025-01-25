package com.thehotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerenciaManutencoes {
    private List<Manutencao> manutencoes;

    public GerenciaManutencoes() {
        this.manutencoes = new ArrayList<>();
    }

    // Adiciona uma nova manutenção associada a um quarto
    public void adicionarManutencao(int id, String tipo, String descricao, Date data, Quarto quarto) {
        if (quarto == null) {
            throw new IllegalArgumentException("Quarto não pode ser nulo.");
        }
        Manutencao manutencao = new Manutencao(id, tipo, descricao, data, quarto);
        manutencoes.add(manutencao);
    }

    // Lista manutenções pendentes 
    public List<Manutencao> ManutencoesPendentes() {
        List<Manutencao> pendentes = new ArrayList<>();
        for (Manutencao m : manutencoes) {
            if (!m.isRealizada()) {
                pendentes.add(m);
            }
        }
        return pendentes;
    }

    // Lista histórico de manutenções realizadas para um quarto específico
    public List<Manutencao> HistoricoDeManutencoes(int quartoId) {
        List<Manutencao> realizadas = new ArrayList<>();
        for (Manutencao m : manutencoes) {
            if (m.isRealizada() && m.getQuarto().getId() == quartoId) {
                realizadas.add(m);
            }
        }
        return realizadas;
    }

    // Marca uma manutenção como realizada
    public boolean ManutencaoRealizada(int id) {
        for (Manutencao m : manutencoes) {
            if (m.getId() == id) {
                if (!m.isRealizada()) {
                    m.marcarComoRealizada();
                    return true; // Sucesso
                } else {
                    return false; // Já realizada
                }
            }
        }
        return false; // Não encontrada
    }
}
