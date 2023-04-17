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
Feature: Title of your feature1
  I want to use this template for my feature file


  Background: I navigate to google search page
  	When I navigate to google search page

  @tag1
  Scenario: Search key in google
    Given I want to search keyword in google
    And search for "Testing"
    And click on enter
    Then I should see google result page contsins 'Testing'
    And check result contain search keyword

#	@tag1
  #Scenario: Search key in google
    #Given I want to search keyword in google
    #And search for 
    #|Automation|
    #And click on enter
    #Then I should see google result page contsins 'Automation'
    #And check result contain search keyword

