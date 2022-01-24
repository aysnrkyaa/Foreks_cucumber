
Feature: Foreks steps

  Background: Foreks login
    Given go to foreks page
    And write username
    And write password
    When click login button
    Then check the success message

  Scenario:Read foreks news
    Given open modul list page
    And click news widget
    When open the widget
    Then read the news


