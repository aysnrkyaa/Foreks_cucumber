Feature: Foreks Not login  steps

  Scenario: Foreks not login
    Given go to foreks login page
    And write foreks username
    And write not true password
    When click foreks login button
    Then check the error message
