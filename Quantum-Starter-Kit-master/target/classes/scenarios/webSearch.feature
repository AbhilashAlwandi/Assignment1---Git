@Web
Feature: Google Search

  @WebSearch
  Scenario: Search Quantum
    Given I am on Google Search Page
    When I search for "quantum perfecto"
    Then it should have "Introducing Quantum Framework" in search results
    Then I am on Google Search Page

#  @WebResultsList
#  Scenario: Search Quantum with results
#    Given I am on Google Search Page
#    When I search for "Project-Quantum Quantum-Starter-Kit"
#    Then it should have following search results:
#      | Starter Kit |
#      | GitHub |
#      | Getting Started |
#      
#  @WebSearchListContains
#  Scenario: Search Quantum with results
#    Given I am on Google Search Page
#    When I search for "http://projectquantum.io"
#    Then it should have "About: Project Quantum" in search results
#
#  @WebDD
#  Scenario Outline: Search Keyword Inline Data
#    Given I am on Google Search Page
#    When I search for "<searchKey>"
#    Then it should have "<searchResult>" in search results
#
#    Examples:
#      | recId | searchKey               | searchResult                  |
#      | 1     | quantum perfecto        | Introducing Quantum Framework |
#      | 2     | Project-Quantum Quantum-Starter-Kit | GitHub |
#      | 3	  | perfecto quantum framework | Introducing Quantum Framework |
#
#  @WebDDxml	
#  Scenario Outline: Search Keyword XML Data
#    Given I am on Google Search Page
#    When I search for "<searchKey>"
#    Then it should have "<searchResult>" in search results
#
#    #xml file must be in directory listed in env.resources property
#    Examples: {'key' : 'demo.websearch.dataset'}
#
#  @WebDDcsv
#  Scenario Outline: Search Keyword CSV Data
#    Given I am on Google Search Page
#    When I search for "<searchKey>"
#    Then it should have "<searchResult>" in search results
#
#    #for csv, txt, xls files specify datafile location
#    Examples: {'datafile' : 'src/main/resources/data/testData.csv'}
#    
