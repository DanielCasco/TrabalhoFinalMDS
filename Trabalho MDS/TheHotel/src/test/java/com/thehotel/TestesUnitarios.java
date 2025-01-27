package com.thehotel;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestesUnitarios {

    private Manutencao manutencao;
    private Quarto quarto;
    private Reserva reserva;
    private GerenciaReservas GerenciaReservas;
    private GerenciaManutencoes gerenciadorManutencoes;

    @BeforeEach
    void setup() {
        quarto = new Quarto(1, 2, 1, "Vista para o mar", true, 1, true);
        manutencao = new Manutencao(1, "Elétrica", "Troca de lâmpadas", new Date(), quarto);
        reserva = new Reserva(1, new Date(), new Date());
        GerenciaReservas = new GerenciaReservas();
        gerenciadorManutencoes = new GerenciaManutencoes();
    }


    @Test
    public void testCriarQuarto() {
        Quarto quartoCriado = new Quarto(2, 3, 2, "cidade", false, 2, false);
        Quarto.criarQuarto(quartoCriado);
        
        assertNotNull(quartoCriado);
        assertEquals(2, quartoCriado.getId());
        assertEquals(3, quartoCriado.getCapacidade());
        assertEquals(2, quartoCriado.getNumCamas());
        assertEquals("cidade", quartoCriado.getTipoVista());
        assertFalse(quartoCriado.isCozinha());
        assertEquals(2, quartoCriado.getNumWC());
        assertFalse(quartoCriado.isVaranda());
    }

    @Test
    public void testEditarQuarto() {
        quarto.setCapacidade(4);
        quarto.setNumCamas(2);
        quarto.setTipoVista("piscina");
        quarto.setCozinha(false);
        quarto.setNumWC(2);
        quarto.setVaranda(false);
        
        assertEquals(4, quarto.getCapacidade());
        assertEquals(2, quarto.getNumCamas());
        assertEquals("piscina", quarto.getTipoVista());
        assertFalse(quarto.isCozinha());
        assertEquals(2, quarto.getNumWC());
        assertFalse(quarto.isVaranda());
    }

    @Test
    public void testRemoverQuarto() {
        Quarto.criarQuarto(quarto);  
        
        Quarto.removerQuarto(quarto);
        
        assertEquals(1, quarto.getId());  
    }

    @Test
    public void testCriarReserva() {
        Date dataInicio = new Date();
        Date dataFim = new Date(dataInicio.getTime() + 86400000L); 

        Reserva reservaCriada = new Reserva(2, dataInicio, dataFim);
        reservaCriada.adicionarQuarto(quarto); 
        Utilizador hospede = new Utilizador(1, "teste", "teste@email.com");
        reservaCriada.adicionarHospede(hospede); 

        assertNotNull(reservaCriada);
        assertEquals(2, reservaCriada.getId());
        assertEquals(dataInicio, reservaCriada.getDataInicio());
        assertEquals(dataFim, reservaCriada.getDataFim());
        assertEquals("Pendente", reservaCriada.getStatus());
        assertEquals(1, reservaCriada.getQuartos().size());
        assertEquals(quarto, reservaCriada.getQuartos().get(0));
        assertEquals(1, reservaCriada.getHospedes().size());
        assertEquals(hospede, reservaCriada.getHospedes().get(0));
    }


    @Test
    public void testConfirmarReserva() {

        Quarto quarto = new Quarto(1, 2, 1, "Vista para o mar", true, 1, true);
        Utilizador utilizador = new Utilizador(1, "teste", "teste@example.com");
    
        GerenciaReservas.adicionarQuarto(quarto); // Adiciona o quarto
        GerenciaReservas.adicionarUtilizador(utilizador); // Adiciona o utilizador

    // Criar uma reserva
    Reserva reserva = GerenciaReservas.criarReserva(1, new Date(), new Date(), 1, 1);

    // Confirmar a reserva
    GerenciaReservas.confirmarReserva(1);

    // Verificar o status da reserva
    assertEquals("Confirmado", reserva.getStatus());
    }


    @Test
    void testSugerirQuarto() {
        Date dataInicio = new Date();
        Date dataFim = new Date(dataInicio.getTime() + 86400000L); 

        // Adiciona quartos
        Quarto quarto1 = new Quarto(1, 2, 1, "Vista para o mar", true, 1, true);
        Quarto quarto2 = new Quarto(2, 4, 2, "Vista para a cidade", false, 2, true);
        Quarto quarto3 = new Quarto(3, 2, 1, "Vista para a montanha", false, 1, false);

        GerenciaReservas.adicionarQuarto(quarto1);
        GerenciaReservas.adicionarQuarto(quarto2);
        GerenciaReservas.adicionarQuarto(quarto3);

        // Testar sugestão de quarto 
        Quarto sugestao = GerenciaReservas.sugerirReserva(dataInicio, dataFim, 2, true, "Vista para o mar");

        assertNotNull(sugestao);
        assertEquals(1, sugestao.getId());
        assertEquals("Vista para o mar", sugestao.getTipoVista());
        assertTrue(sugestao.isCozinha());

        // Testar capacidade maior que a máxima disponível
        Quarto sugestaoInvalida = GerenciaReservas.sugerirReserva(dataInicio, dataFim, 6, true, "Vista para o mar");
        assertNull(sugestaoInvalida);

        // Testar quando não houver quarto com o tipo de vista solicitado
        Quarto sugestaoVistaInvalida = GerenciaReservas.sugerirReserva(dataInicio, dataFim, 2, true, "Vista para a piscina");
        assertNull(sugestaoVistaInvalida);

        // Testar quando não houver quarto com cozinha disponível
        Quarto sugestaoSemCozinha = GerenciaReservas.sugerirReserva(dataInicio, dataFim, 2, true, "Vista para a cidade");
        assertNull(sugestaoSemCozinha);
    }


    @Test
    void testCriarReservaParaQuartoDisponivel() {
        Date dataInicio = new Date();
        Date dataFim = new Date(dataInicio.getTime() + 86400000L); 

        // Adicionar quarto disponível e hóspede
        GerenciaReservas.adicionarQuarto(quarto);
        Utilizador hospede = new Utilizador(1, "João", "joao@email.com");
        GerenciaReservas.adicionarUtilizador(hospede);

        // Criar a reserva
        Reserva novaReserva = GerenciaReservas.criarReserva(1, dataInicio, dataFim, 1, 1);

        // Verificações
        assertNotNull(novaReserva);
        assertEquals(1, novaReserva.getId());
        assertEquals(dataInicio, novaReserva.getDataInicio());
        assertEquals(dataFim, novaReserva.getDataFim());
        assertEquals("Pendente", novaReserva.getStatus());
        assertEquals(1, novaReserva.getQuartos().size());
        assertFalse(quarto.isDisponivel()); // Quarto agora está indisponível
    }

    @Test
    void testCriarReservaParaQuartoIndisponivel() {
        // Definir quarto como indisponível
        quarto.setDisponivel(false);
        GerenciaReservas.adicionarQuarto(quarto);
        Utilizador hospede = new Utilizador(1, "João", "joao@email.com");
        GerenciaReservas.adicionarUtilizador(hospede);

        // Verificar exceção ao tentar criar reserva para quarto indisponível
        Date dataInicio = new Date();
        Date dataFim = new Date(dataInicio.getTime() + 86400000L);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            GerenciaReservas.criarReserva(1, dataInicio, dataFim, 1, 1);
        });

        assertEquals("O quarto não está disponível para reserva.", exception.getMessage());
    }








    @Test
    void testAdicionarManutencao() {
        gerenciadorManutencoes.adicionarManutencao(1, "Elétrica", "Trocar lâmpadas", new Date(), quarto);
        List<Manutencao> pendentes = gerenciadorManutencoes.ManutencoesPendentes();

        assertEquals(1, pendentes.size());
        assertEquals("Elétrica", pendentes.get(0).getTipo());
        assertEquals(quarto, pendentes.get(0).getQuarto());
    }

    @Test
    void testManutencoesPendentes() {
        Quarto quarto2 = new Quarto(2, 3, 2, "Vista para a cidade", false, 2, false);

        gerenciadorManutencoes.adicionarManutencao(1, "Elétrica", "Trocar lâmpadas", new Date(), quarto);
        gerenciadorManutencoes.adicionarManutencao(2, "Água", "Reparar água fria", new Date(), quarto2);

        List<Manutencao> pendentes = gerenciadorManutencoes.ManutencoesPendentes();

        assertEquals(2, pendentes.size());
        assertEquals("Elétrica", pendentes.get(0).getTipo());
        assertEquals("Água", pendentes.get(1).getTipo());
    }


    @Test
    void testManutencaoRealizada() {
        gerenciadorManutencoes.adicionarManutencao(1, "Elétrica", "Trocar lâmpadas", new Date(), quarto);
        boolean sucesso = gerenciadorManutencoes.ManutencaoRealizada(1);

        assertTrue(sucesso);

        List<Manutencao> historico = gerenciadorManutencoes.HistoricoDeManutencoes(quarto.getId());
        assertEquals(1, historico.size());
        assertTrue(historico.get(0).isRealizada());
        assertEquals(quarto, historico.get(0).getQuarto());
    }

    @Test
    void testAdicionarManutencaoSemQuarto() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gerenciadorManutencoes.adicionarManutencao(1, "Elétrica", "Trocar lâmpadas", new Date(), null);
        });

        assertEquals("Quarto não pode ser nulo.", exception.getMessage());
    }

    @Test
    void testReservaInicializacao() {
        assertEquals(1, reserva.getId());
        assertEquals("Pendente", reserva.getStatus());
        assertTrue(reserva.getQuartos().isEmpty());
        assertTrue(reserva.getHospedes().isEmpty());
    }
    
}
