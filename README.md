# TrabalhoFinalMDS

 Este trabalho, desenvolvido no âmbito da disciplina de Metodologias e Desenvolvimento de Software, tem como objetivo a implementação do sistema TheHotel que foi especificado na primeira parte do projeto através de requisitos e diagramas de classes. Para isto, começamos por criar as classes que foram definidas no diagrama. Decidímos não criar as classes ocorrencias, avaliação e hóspede já que as funções relacionadas a estas classes não devem ser implementadas. Também decidimos não criar uma classe hóspede uma vez que todas as funções de reserva serão feitas pelo funcionário ou gestor, simplesmente usando a classe utilizador para os exemplos demonstrados no main.

## Classes

### Utilizador

A classe utilizador representa qualquer utilizador do sistema, seja hóspede, funcionário ou gestor. Apresenta os atributos id, nome e email e as funções getters e setters para maniuplar as instâncias dessa classe.

### Funcionário

A classe funcionário é uma extensão da classe utilizador que representa um funcionário do hotel, tendo o seu cargo e credenciais atributo para além daqueles herdados da classe utilizador.

### Gestor

A classe gestor é uma extensão de funcionário, sendo aquele encarreguado da gestão do hotel.

### Quarto

A classe quarto guarda os quartos do hotel e os seus atributos id, capacidade , numero de camas, tipo de vista, ter cozinha ou não, numero de casas de banho, ter varanda ou não e se está disponivel. Também guarda o arrayList de Manutenções que estão associadas a esse quarto.

### Reserva

Esta classe guarda as reservas efetuadas no sistema e os seus atributos de id, data de inicio, data de fim, status(pendente ou confirmada). Cria também dois arrays para os quartos e hóspedes associados a essa reserva.

### Manutenção

Esta classe representa as manutenções, guardando o seu id, tipo de manutenção e descrição da tarefa. Guarda também a data de quando deve ser realizada, um boolean para indicar se já está completa e o id do quarto em a que está associada. 

## Funções do sistema

Para implementar as funcionalidades desejadas, foram criadas dois ficheiros de gestão(GerenciaReservas e GerenciaManutencoes) onde são definidas as várias funções que cumprirão os requisitos especificados na +rimeira parte do trabalho. Não achamos necessário criar um ficheiro para funções em relação ao quarto pois as funções getters e setters no quarto foram suficiente para as operações relacionadas a essa classe.

### GerenciaReservas

As funções definidas neste ficheiro são:

- criarReserva, que cria uma reserva caso o quarto desejado esteja disponível. Quando a reserva é criada, esse quarto passa a não estar disponível.
- listarReservas, que serve para a consulta de reservas.
- sugerirReserva, que recebe filtros do utilizador e retorna um quarto que tenha atributos semelhantes.

### GerenciaManutenções

As funções neste ficheiro são:

- adicionarManutencao, que cria uma nova manutenção por realizar.
- ManutencoesPendentes, que retorna uma lista das manutenções pendentes.
- HistoricoDeManutencoes, que retorna as manutenções realizadas em um quarto especifico.
- ManutencaoRealizada, que marca uma manutenção como realizada.

# Testes unitários

Dentro do ficheiro TestesUnitarios encontram-se todos os testes implementados para verificar se uma função está corretamente implementada, existindo pelo menos um teste por cada função.

# Main

Finalmente foi criado o main que serve como exemplo da funcionalidade do sistema, criando um menu para chamar cada funcionalidade te seguir a lógica descrita nos use cases.
