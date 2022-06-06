Feature: Contacts page


  Scenario:Verify Page Title
    Given the user is on the main page
    When the user navigates to "Contacts"
    Then the user should see the page title as "Contact Us | Invent Analytics"



  @wip
  Scenario Outline:User should not be able to submit without filled required field
    Given user is on the contact us page
    When the user fills following areas
      | Firstname   | <Firstname> |
      | Lastname    | <Lastname>  |
      | CompanyName | <Company>   |
      | JobTitle    | <JobTitle>  |
      | Country     | <Country>   |

    And the user able to click "Submit Button"
    Then the user should see "Please complete all required fie." as error message

    Examples:
      | Firstname      | Lastname  | Company         | JobTitle         | Country |
      | Emre           | Tan       | Invent Analytics| Associate Manager| Turkey  |
