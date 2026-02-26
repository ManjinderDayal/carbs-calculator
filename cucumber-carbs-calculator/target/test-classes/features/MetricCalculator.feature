Feature: Carbohydrate Calculator - Metric Units (TC-001 & TC-002)

  Background:
    Given Page open in Chrome.
    And Metric units tab active.

  Scenario Outline: Valid metric inputs return a complete result table for <gender> user
    When I enter age as <age>
    And I select gender as <gender>
    And I enter height as <height> cm
    And I enter weight as <weight> kg
    And I select activity level as <activity>
    And I click the Calculate button
    Then the result table should appear with <rows> on the page
    And Daily Calorie Allowance and carb gram values as 40%, 55%, 65%, 75% percentage column
    And Daily Calorie Allowance and carb gram values should not be zero

    Examples:
      | age | gender | height | weight | activity                              | rows |
      | 30  | male   | 178    | 80     | "Moderate: exercise 4-5 times/week"   | 5    |
      | 28  | female | 163    | 60     | "Light: exercise 1-3 times/week"      | 5    |