Feature:
  Select section feature https://www.invitro.ru

  Scenario Outline: select section test
    Given user opens the site
    When select section <section>

    Examples:
      | section |
      | DOCTOR  |
