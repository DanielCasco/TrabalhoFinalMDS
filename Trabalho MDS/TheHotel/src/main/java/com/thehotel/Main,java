package com.thehotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Quarto> listaDeQuartos = new ArrayList<>();
        GerenciaReservas GerenciaReservas = new GerenciaReservas();
        GerenciaManutencoes GerenciaManutencoes = new GerenciaManutencoes();
        Scanner scanner = new Scanner(System.in);

        // Hóspedes
        Utilizador hospede1 = new Utilizador(1, "José", "exemplo@email.com");
        Utilizador hospede2 = new Utilizador(2, "Maria", "OutroEx@email.com");

        GerenciaReservas.adicionarUtilizador(hospede1);
        GerenciaReservas.adicionarUtilizador(hospede2);

        while (true) {
            System.out.println("\n Sistema de Gestão de Quartos, Reservas e Manutenções ");
            System.out.println("1. Criar quarto");
            System.out.println("2. Editar quarto");
            System.out.println("3. Remover quarto");
            System.out.println("4. Listar quartos");
            System.out.println("5. Efetuar reserva");
            System.out.println("6. Listar reservas");
            System.out.println("7. Confirmar reserva");
            System.out.println("8. Adicionar manutenção");
            System.out.println("9. Listar manutenções pendentes");
            System.out.println("10. Listar histórico de manutenções");
            System.out.println("11. Marcar manutenção como realizada");
            System.out.println("12. Sugerir Quarto");
            System.out.println("13. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarQuarto(listaDeQuartos, GerenciaReservas, scanner);
                    break;
                case 2:
                    editarQuarto(listaDeQuartos, scanner);
                    break;
                case 3:
                    removerQuarto(listaDeQuartos, scanner);
                    break;
                case 4:
                    listarQuartos(listaDeQuartos);
                    break;
                case 5:
                    criarReserva(GerenciaReservas, scanner);
                    break;
                case 6:
                    listarReservas(GerenciaReservas);
                    break;
                case 7:
                    confirmarReserva(GerenciaReservas, scanner);
                    break;
                case 8:
                    adicionarManutencao(GerenciaManutencoes, listaDeQuartos, scanner);
                    break;
                case 9:
                    ManutencoesPendentes(GerenciaManutencoes);
                    break;
                case 10:
                    HistoricoDeManutencoes(GerenciaManutencoes, scanner);
                    break;
                case 11:
                    ManutencaoRealizada(GerenciaManutencoes, scanner);
                    break;
                case 12:
                    sugerirReserva(GerenciaReservas, scanner);
                    break;               
                case 13:
                    System.out.println("Saindo.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    private static void confirmarReserva(GerenciaReservas GerenciaReservas, Scanner scanner) {
        System.out.println("\n Confirmar Reserva ");
        System.out.print("Digite o ID da reserva a ser confirmada: ");
        int reservaId = scanner.nextInt();

        try {
            GerenciaReservas.confirmarReserva(reservaId);
            System.out.println("Reserva confirmada com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void criarQuarto(List<Quarto> listaDeQuartos, GerenciaReservas GerenciaReservas, Scanner scanner) {
        System.out.println("\n Criar Quarto ");
        System.out.print("ID do quarto: ");
        int id = scanner.nextInt();
        System.out.print("Capacidade do quarto: ");
        int capacidade = scanner.nextInt();
        System.out.print("Número de camas: ");
        int numCamas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo de vista: ");
        String tipoVista = scanner.nextLine();
        System.out.print("Cozinha disponível (true/false): ");
        boolean cozinha = scanner.nextBoolean();
        System.out.print("Número de casas de banho: ");
        int numWC = scanner.nextInt();
        System.out.print("Varanda disponível (true/false): ");
        boolean varanda = scanner.nextBoolean();

        Quarto quarto = new Quarto(id, capacidade, numCamas, tipoVista, cozinha, numWC, varanda);
        listaDeQuartos.add(quarto);
        GerenciaReservas.adicionarQuarto(quarto);
        System.out.println("Quarto criado com sucesso: " + quarto);
    }

    private static void editarQuarto(List<Quarto> listaDeQuartos, Scanner scanner) {
        System.out.println("\n Editar Quarto ");
        System.out.print("Digite o ID do quarto a ser editado: ");
        int id = scanner.nextInt();

        Quarto quarto = listaDeQuartos.stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);

        if (quarto == null) {
            System.out.println("Quarto com ID " + id + " não encontrado.");
            return;
        }

        System.out.println("Editando o quarto: " + quarto);
        System.out.print("Nova capacidade (atual: " + quarto.getCapacidade() + "): ");
        quarto.setCapacidade(scanner.nextInt());
        System.out.print("Novo número de camas (atual: " + quarto.getNumCamas() + "): ");
        quarto.setNumCamas(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Novo tipo de vista (atual: " + quarto.getTipoVista() + "): ");
        quarto.setTipoVista(scanner.nextLine());
        System.out.print("Cozinha disponível (atual: " + quarto.isCozinha() + "): ");
        quarto.setCozinha(scanner.nextBoolean());
        System.out.print("Novo número de casas de banho (atual: " + quarto.getNumWC() + "): ");
        quarto.setNumWC(scanner.nextInt());
        System.out.print("Varanda disponível (atual: " + quarto.isVaranda() + "): ");
        quarto.setVaranda(scanner.nextBoolean());

        System.out.println("Quarto editado: " + quarto);
    }

    private static void removerQuarto(List<Quarto> listaDeQuartos, Scanner scanner) {
        System.out.println("\n Remover Quarto ");
        System.out.print("Digite o ID do quarto a ser removido: ");
        int id = scanner.nextInt();

        Quarto quarto = listaDeQuartos.stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);

        if (quarto == null) {
            System.out.println("Quarto com ID " + id + " não encontrado.");
            return;
        }

        listaDeQuartos.remove(quarto);
        Quarto.removerQuarto(quarto);
    }

    private static void listarQuartos(List<Quarto> listaDeQuartos) {
        System.out.println("\n Lista de Quartos ");
        if (listaDeQuartos.isEmpty()) {
            System.out.println("Nenhum quarto registado.");
            return;
        }
        listaDeQuartos.forEach(System.out::println);
    }

    private static void criarReserva(GerenciaReservas GerenciaReservas, Scanner scanner) {
        System.out.println("\n Criar Reserva ");
        System.out.print("ID da reserva: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            System.out.print("Data de início (dd/MM/yyyy): ");
            String inicioStr = scanner.nextLine();
            Date dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(inicioStr);

            System.out.print("Data de fim (dd/MM/yyyy): ");
            String fimStr = scanner.nextLine();
            Date dataFim = new SimpleDateFormat("dd/MM/yyyy").parse(fimStr);

            System.out.print("ID do quarto: ");
            int quartoId = scanner.nextInt();
            System.out.print("ID do hóspede: ");
            int hospedeId = scanner.nextInt();

            Reserva novaReserva = GerenciaReservas.criarReserva(id, dataInicio, dataFim, quartoId, hospedeId);
            System.out.println("Reserva criada com sucesso: " + novaReserva);
        } catch (ParseException e) {
            System.out.println("Erro ao inserir datas. Certifique-se de usar o formato dd/MM/yyyy.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarReservas(GerenciaReservas GerenciaReservas) {
        System.out.println("\n Lista de Reservas ");
        List<Reserva> reservas = GerenciaReservas.listarReservas();
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva registrada.");
        } else {
            reservas.forEach(System.out::println);
        }
    }

    private static void sugerirReserva(GerenciaReservas GerenciaReservas, Scanner scanner) {
        System.out.println("\n Sugerir quarto ");
        System.out.print("Data de início (dd/MM/yyyy): ");
        String inicioStr = scanner.nextLine();
        System.out.print("Data de fim (dd/MM/yyyy): ");
        String fimStr = scanner.nextLine();
    
        try {
            Date dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(inicioStr);
            Date dataFim = new SimpleDateFormat("dd/MM/yyyy").parse(fimStr);
    
            System.out.print("Capacidade mínima: ");
            String capacidadeStr = scanner.nextLine();
            Integer capacidade = capacidadeStr.isEmpty() ? null : Integer.parseInt(capacidadeStr);
    
            System.out.print("Cozinha disponível: ");
            String cozinhaStr = scanner.nextLine();
            Boolean cozinha = cozinhaStr.isEmpty() ? null : Boolean.parseBoolean(cozinhaStr);
    
            System.out.print("Tipo de vista (deixe vazio para qualquer): ");
            String tipoVista = scanner.nextLine();
            tipoVista = tipoVista.isEmpty() ? null : tipoVista;
    
            Quarto sugerido = GerenciaReservas.sugerirReserva(dataInicio, dataFim, capacidade, cozinha, tipoVista);
    
            if (sugerido != null) {
                System.out.println("Quarto sugerido: " + sugerido);
                System.out.print("Aceitar sugestão e criar reserva? (S/N): ");
                String resposta = scanner.nextLine();
    
                if ("S".equalsIgnoreCase(resposta)) {
                    System.out.print("ID da reserva: ");
                    int reservaId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID do hóspede: ");
                    int hospedeId = scanner.nextInt();
                    scanner.nextLine();
    
                    Reserva novaReserva = GerenciaReservas.criarReserva(reservaId, dataInicio, dataFim, sugerido.getId(), hospedeId);
                    GerenciaReservas.confirmarReserva(novaReserva.getId());
                    System.out.println("Reserva criada com sucesso.");
                }
            } else {
                System.out.println("Nenhum quarto disponível atende aos critérios.");
            }
        } catch (ParseException e) {
            System.out.println("Erro ao inserir datas.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private static void adicionarManutencao(GerenciaManutencoes GerenciaManutencoes, List<Quarto> listaDeQuartos, Scanner scanner) {
        System.out.println("\n Adicionar Manutenção ");
        System.out.print("ID da manutenção: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo de manutenção: ");
        String tipo = scanner.nextLine();
        System.out.print("Descrição da manutenção: ");
        String descricao = scanner.nextLine();
        System.out.print("Data da manutenção (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        System.out.print("ID do quarto: ");
        int quartoId = scanner.nextInt();

        Quarto quarto = listaDeQuartos.stream()
                .filter(q -> q.getId() == quartoId)
                .findFirst()
                .orElse(null);

        if (quarto == null) {
            System.out.println("Erro: Quarto com ID " + quartoId + " não encontrado.");
            return;
        }

        try {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
            GerenciaManutencoes.adicionarManutencao(id, tipo, descricao, data, quarto);
            System.out.println("Manutenção adicionada com sucesso.");
        } catch (ParseException e) {
            System.out.println("Erro ao inserir a data. Certifique-se de usar o formato dd/MM/yyyy.");
        }
    }

    private static void ManutencoesPendentes(GerenciaManutencoes GerenciaManutencoes) {
        System.out.println("\n Lista de Manutenções Pendentes ");
        List<Manutencao> pendentes = GerenciaManutencoes.ManutencoesPendentes();
        if (pendentes.isEmpty()) {
            System.out.println("Nenhuma manutenção pendente.");
        } else {
            pendentes.forEach(System.out::println);
        }
    }

    private static void HistoricoDeManutencoes(GerenciaManutencoes GerenciaManutencoes, Scanner scanner) {
        System.out.println("\n Histórico de Manutenções Realizadas ");
        System.out.print("Digite o ID do quarto: ");
        int quartoId = scanner.nextInt();

        List<Manutencao> realizadas = GerenciaManutencoes.HistoricoDeManutencoes(quartoId);
        if (realizadas.isEmpty()) {
            System.out.println("Nenhuma manutenção realizada para este quarto.");
        } else {
            realizadas.forEach(System.out::println);
        }
    }

    private static void ManutencaoRealizada(GerenciaManutencoes GerenciaManutencoes, Scanner scanner) {
        System.out.println("\n Marcar Manutenção como Realizada ");
        System.out.print("Digite o ID da manutenção: ");
        int manutencaoId = scanner.nextInt();

        boolean sucesso = GerenciaManutencoes.ManutencaoRealizada(manutencaoId);
        if (sucesso) {
            System.out.println("Manutenção marcada como realizada com sucesso.");
        } else {
            System.out.println("Erro: Manutenção não encontrada ou já realizada.");
        }
    }
}
