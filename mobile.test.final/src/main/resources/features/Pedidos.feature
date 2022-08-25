@Pedidos
Feature: Pedidos

  Scenario: Lista de pedidos
    Given que o usuario esteja logado
    When o usuario entrar na lista de pedidos
    Then podera acessar o ultimo detalhe do pedido

