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

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public List<Utilizador> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<Utilizador> hospedes) {
        this.hospedes = hospedes;
    }
    
}
