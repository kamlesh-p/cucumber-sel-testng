#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature2
  I want to use this template for my feature file


  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to search multiple keywords
    When search for "<keyword>"
      And click on enter
    Then I should see google result page contsins "<keyword>"
     And verify and go back to search page

    Examples: 
      | keyword  |
      | testing | 
      | automation | 
      
      
