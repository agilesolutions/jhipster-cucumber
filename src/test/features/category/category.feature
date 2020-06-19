Feature: Category management

    Scenario: Retrieve transmit category
        When I search category 2
        Then the category is found
        And its description is 'transmit'
