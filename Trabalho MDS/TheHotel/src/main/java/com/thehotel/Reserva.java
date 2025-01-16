package com.thehotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {
    private int id;
    private Date dataInicio;
    private Date dataFim;
    private String status;
    private List<Quarto> quartos;
    private List<Utilizador> hospedes;

    public Reserva(int id, Date dataInicio, Date dataFim) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = "Pendente";
        this.quartos = new ArrayList<>();
        this.hospedes = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void adicionarHospede(Utilizador hospede) {
        hospedes.add(hospede);
    }

    // Getters e setters omitidos por brevidade
}