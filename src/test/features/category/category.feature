Feature: Category management

   Scenario Outline: Retrieve transmit category
        When I search category <id>
        Then the category is found
        And its description is '<description>'
        
   Examples:
   
    | id             | description |
    | 1              | Table       |
    | 3              | Chief       |
    | 2 		     | transmit    |        
