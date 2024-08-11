@idnow_automation
Feature: IDNow Automation tasks

  @verify_key_browser_matrix_support_for_web
  Scenario: verify key browser matrix support for web minimum version API
    Given I send a GET request to "v1/ihrebank"
    And the response status code should be 200
    When I ensure that the autoident has the browserSupportMatrix
    And I verify web considering the minimum version supported for Desktop
    Then I verify web considering the minimum version supported for Mobile

  @verify_identification_not_complete_screen_ios
  Scenario: Verify identification not complete screen iOS
    Given I Validate that the home screen is displayed with ident edit box and start button
    And I enter the ID "TS2-QKKRD" and select the start button
    And I validate the terms and conditions screen is displayed
    And I click on close icon on top left corner
    And I validate the options with the reasons are displayed
    When I select one quit reason and select quit session
    Then I validate the intermediate screen displayed before the app redirects to the home screen

#  @verify_identification_not_complete_screen_android
#  Scenario: Verify identification not complete screen Android
#    Given I Validate that the home screen is displayed with ident edit box and start button
#    And I enter the ID "TS2-QKKRD" and select the start button
#    And I validate the terms and conditions screen is displayed
#    And I click on close icon on top left corner
#    And I validate the options with the reasons are displayed
#    When I select one quit reason and select quit session
#    Then I validate the intermediate screen displayed before the app redirects to the home screen

