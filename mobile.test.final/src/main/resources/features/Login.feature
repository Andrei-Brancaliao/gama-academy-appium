@Login @End2End
Feature: Login
  
  @LoginComSucesso
  Scenario Outline: Realizar Login com sucesso
  	Given que o usuario esteja na tela inicial do app
    When digitar seu "<login>" no campo Login
    And digitar a "<senha>" no campo Senha
    And clicar no botao Login
    Then sera exibida a tela de quadrinhos para o usuario

    Examples: 
      | login                      | senha  |
      | andreibrancaliao@gmail.com | 123456 |

