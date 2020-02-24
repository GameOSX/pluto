    Feature: Cover for a trip
        Covers for different trip types

    Scenario: Cover for single trip
        Given I want to buy cover for single trip
        When I select cover for single trip
        And I fill all required data
        And I select quote for single trip
        Then I will be able to buy such a cover with a card payment


    Scenario: Select annual cover
        Given I want to buy cover for a year
        When I select annual cover
        And I fill required data for worldwide
        Then I will get annual quote proposition
        And Will be able to pay for if via paypal


    Scenario Outline: Check validation for name and age
        Given I want to check validation for name and age
        When I fill "<name>" and "<age>"
        Then I will get proper "<validation>"

        Examples:
        |name       |  age |validation |
        |Mic Tre    |   30 |       true|
        |Doe        |   30 |      false|
        |Jon Doe    |   17 |      false|