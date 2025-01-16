package com.thehotel;

import java.util.Date;

public class Manutencao {
    private int id;
    private String tipo;
    private String descricao;
    private Date data;
    private boolean realizada;

    public Manutencao(int id, String tipo, String descricao, Date data) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.realizada = false;
    }

    public void marcarComoRealizada() {
        this.realizada = true;
    }

    
}
