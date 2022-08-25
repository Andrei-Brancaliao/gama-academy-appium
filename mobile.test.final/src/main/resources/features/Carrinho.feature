@End2End
@Carrinho
Feature: Carrinho

  @CarrinhoVazio
  Scenario: Cart should display with a empty icon when all itens are removed
    Given I am logged in
    And I have added a item to the cart
    And I am at the cart page
    When I click on the remove button at the list
   	Then the page will be shown as empty with a image
   	
   @CarrinhoAdicionar
   Scenario: Cart should display all added items in the list
   	Given I am logged in

