@complete
Feature: Yandex Translator API 3

  Scenario: TestExampleScenario 3
    Given Set up YandexTranslator REST API
    When Translate text from en to uk
    Then Expected translation should be текст
    When Translate hello from en to uk
    Then Expected translation should be привіт
    When Translate circle from en to uk
    Then Expected translation should be коло
    When Translate rectangle from en to uk
    Then Expected translation should be прямокутник

  Scenario Outline: TestExampleWithExamples 3
    Given Set up YandexTranslator REST API
    When Translate <sourceText> from <from> to <to>
    Then Expected translation should be <expectedTranslation>

    Examples:
      | sourceText | from | to | expectedTranslation |
      | text       | en   | uk | текст               |
      | hello      | en   | uk | привіт              |
      | circle     | en   | uk | коло                |
      | rectangle  | en   | uk | прямокутник         |