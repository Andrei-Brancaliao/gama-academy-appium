@Login @End2End
Feature: Login
  
  Given que o usuario esteja na tela inicial do app

  @Login
  Scenario Outline: Title of your scenario outline
    When digitar seu "<login>" no campo Login
    And digitar a "<senha>" no campo Senha
    And clicar no botao Login
    Then sera exibida a tela de quadrinhos para o usuario

    Examples: 
      | login                      | senha  |
      | andreibrancaliao@gmail.com | 123456 |
 ##     | aaaaaaaaaaaaaaaa@gmail.com |      7 |
      
