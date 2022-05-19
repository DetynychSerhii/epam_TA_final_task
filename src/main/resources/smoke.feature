Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check search non-existent item
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    When User clicks "Search" button
    Then User checks that "Nothing matches" text is visible

    Examples:
      | homePage              | keyword          |
      | https://www.asos.com/ | SSNotAvailableSS |

  Scenario Outline: Check filtering by brand
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks "Search" button
    And User clicks on filtering by brand button
    And User clicks on "ASOS 4505" brand button
    Then User checks that items filtering by '<brand>'

    Examples:
      | homePage              | keyword | brand     |
      | https://www.asos.com/ | hat     | ASOS 4505 |


  Scenario Outline: Check adding item to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<firstKeyword>'
    And User clicks "Search" button
    When User clicks on first product on search result page
    And User clicks on first available size
    And User clicks on "ADD TO CART" button
    When User clicks on "BAG" button
    And User clicks on "VIEW BAG" button on bag dropdown
    Then User checks that item was added to cart

    Examples:
      | homePage              | firstKeyword |
      | https://www.asos.com/ | levis        |

  Scenario Outline: Check removing item from cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<firstKeyword>'
    And User clicks "Search" button
    When User clicks on first product on search result page
    And User clicks on size select button
    And User clicks on first available size
    And User clicks on "ADD TO CART" button
    When User clicks on "BAG" button
    And User clicks on "VIEW BAG" button on bag dropdown
    Then User checks that item was added to cart
    And User remove item from cart
    And User checks that bag title is '<expectedTitle>'

    Examples:
      | homePage              | firstKeyword | expectedTitle     |
      | https://www.asos.com/ | adidas       | Your bag is empty |

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks search field visibility
    And User checks "Bag" button visibility
    And User checks "Saved items" button visibility
    And User checks "My Account" button visibility
    When User clicks on "My Account" button
    And User checks "Sign In" button visibility
    And User checks "Join" button visibility
    And User checks "Preferences" button visibility
    And User clicks on "Preferences" button
    And User checks country select on preferences popup
    And User checks currency select on preferences popup
    Then User checks "Update Preferences" button visibility

    Examples:
      | homePage              |
      | https://www.asos.com/ |

  Scenario Outline: Check try enter invalid email wile sign in
    Given User opens '<homePage>' page
    And User clicks on "My Account" button
    And User checks "Sign In" button visibility
    When User clicks on "Sign In" button
    And User enter '<email>' in email field
    And User enter '<password>' in password field
    And User clicks on "Sign In" button on sign in page
    Then User checks that validation error visibility

    Examples:
      | homePage              | email            | password |
      | https://www.asos.com/ | invalidgmail.com | QA       |


  Scenario Outline: Check adding items to "Saved Items"
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<firstItemKeyword>'
    And User clicks "Search" button
    And User clicks "Save for later" button on first product
    And User clicks "Saved Items" button
    Then User checks that amount of items in saved items are '<itemsCount>'

    Examples:
      | homePage              | firstItemKeyword | itemsCount |
      | https://www.asos.com/ | Fred             | 1          |
    Examples:

  Scenario Outline: Check remove items from "Saved Items"
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<firstItemKeyword>'
    And User clicks "Search" button
    And User clicks "Save for later" button on first product
    When User makes search by keyword '<secondItemKeyword>'
    And User clicks "Search" button
    And User clicks "Save for later" button on first product
    And User clicks "Saved Items" button
    And User checks that amount of items in saved items are '<countBeforeRemove>'
    And User remove item from "Saved Items"
    Then User checks that amount of items in saved items are '<countAfterRemove>'

    Examples:
      | homePage              | firstItemKeyword | secondItemKeyword | countBeforeRemove | countAfterRemove |
      | https://www.asos.com/ | hat              | Tommy             | 2                 | 1                |

  Scenario Outline: Check transfer item from saved items to the bag
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks "Search" button
    And User clicks "Save for later" button on first product
    When User clicks "Saved Items" button
    And User clicks on size select dropdown on "Saved Items" page
    And User clicks on first available size option on "Saved Items" page
    And User clicks on "Move To Bag" button
    And User clicks on "BAG" button
    And User clicks on "VIEW BAG" button on bag dropdown
    Then User checks that item was added to cart


    Examples:
      | homePage              | keyword |
      | https://www.asos.com/ | Adidas  |


  Scenario Outline: Check "Help" menu functions
    Given User opens '<homePage>' page
    And User checks "Help&FAQs" menu button visibility
    When User clicks on "Help&FAQs" menu button
    And User checks help search field visibility
    And User checks FAQ topics visibility
    And User checks popular FAQs container visibility
    Then User checks "CONTACT US NOW" button visibility

    Examples:
      | homePage              |
      | https://www.asos.com/ |