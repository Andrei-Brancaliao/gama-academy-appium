@Compra @End2End
Feature: Compra
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Compra realizada com sucesso de um item
    Given que o usuario esteja logado
    And tenha adicionado um item no carrinho
    And esteja no carrinho de compras
    When clicar em fazer o pagamento
    And inserir o "<numeroCartao>" no campo numero do cartao
    And inserir o "<nome>" no campo nome impresso
    And inserir a "<data>" no campo validade
    And inserir os "<safeCode>" no campo codigo de seguranca
    And clicar no botao Pagar agora
    Then um popup sera exibido
    And tera o texto de Compra Finalizada

    Examples: 
      | numeroCartao     | nome         | data   | safeCode |
      | 5522999956363313 | andrei farto | 052023 |      035 |
