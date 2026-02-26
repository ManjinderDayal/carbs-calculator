Feature: Carbohydrate Calculator - US Units

Background:
    Given Page open in Chrome.
    And I click on US units tab

Scenario Outline: Valid US inputs return complete result for <gender>
    When I enter age as <age>
    And I select gender as <gender>
    And I enter height as <feet> feet and <inches> inches
    And I enter weight as <weight> pound
    And I select activity level as <activity>
    And I click the Calculate button
    Then the result table should appear with <rows> on the page
    And Daily Calorie Allowance and carb gram values should not be zero

Examples:
    | age | gender | feet | inches | weight | activity                                    | rows |
    | 30  | male   | 5    | 9      | 170    | "Moderate: exercise 4-5 times/week"         | 5    |
    | 25  | female | 5    | 4      | 130    | "Active: daily exercise or intense exercise 3-4 times/week" | 5 |
