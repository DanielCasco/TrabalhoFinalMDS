package com.thehotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerenciaReservas {
    private List<Reserva> reservas;
    private List<Quarto> quartos; 
    private List<Utilizador> utilizadores;   

    public GerenciaReservas() {
        this.reservas = new ArrayList<>();
        this.quartos = new ArrayList<>(); 
        this.utilizadores = new ArrayList<>();      
    }

    public Reserva criarReserva(int id, Date dataInicio, Date dataFim, int quartoId, int hospedeId) {
        Quarto quarto = quartos.stream()
                .filter(q -> q.getId() == quartoId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Quarto não encontrado"));
    
        if (!quarto.isDisponivel()) {
            throw new IllegalArgumentException("O quarto não está disponível para reserva.");
        }
    
        Utilizador hospede = utilizadores.stream()
                .filter(u -> u.getId() == hospedeId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Hóspede não encontrado"));
        Reserva novaReserva = new Reserva(id, dataInicio, dataFim);
    
        novaReserva.adicionarQuarto(quarto);
        novaReserva.adicionarHospede(hospede);
    
        quarto.setDisponivel(false);
        reservas.add(novaReserva);
    
        return novaReserva;
    }
    

    public List<Reserva> listarReservas() {
        return reservas;
    }

    public void confirmarReserva(int reservaId) {
        
        Reserva reserva = reservas.stream()
                .filter(r -> r.getId() == reservaId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
    
        reserva.setStatus("Confirmado");
    }

    public Quarto sugerirReserva(Date dataInicio, Date dataFim, Integer capacidade, Boolean cozinha, String tipoVista) {
        return quartos.stream()
                .filter(q -> reservas.stream()
                        .noneMatch(r -> r.getQuartos().contains(q) &&
                                (dataInicio.before(r.getDataFim()) && dataFim.after(r.getDataInicio()))))
                .filter(q -> capacidade == null || q.getCapacidade() >= capacidade)
                .filter(q -> cozinha == null || q.isCozinha() == cozinha)
                .filter(q -> tipoVista == null || q.getTipoVista().equalsIgnoreCase(tipoVista))
                .findFirst()
                .orElse(null);
    }
    
    

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void adicionarUtilizador(Utilizador utilizador) {
        utilizadores.add(utilizador);
    }
}
