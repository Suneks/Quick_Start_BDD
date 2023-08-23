package ru.lanit.at.steps.web;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import ru.lanit.at.actions.WebChecks;
import ru.lanit.at.utils.allure.AllureHelper;
import ru.lanit.at.utils.web.pagecontext.PageManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;

public class WebCheckWebSteps extends AbstractWebSteps {

    public WebCheckWebSteps(PageManager pageManager) {
        super(pageManager);
    }


    /**
     * проверка присутствия текста на странице
     *
     * @param text текст
     */
    @Когда("проверить что элемент {string} содержит текст:")
    public void textAppearOnThePage(String elementName, List<String> text) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        WebChecks.elementContainsText(element, text);
        LOGGER.info("элемент '{}' содержит текст '{}'", elementName, text);
    }


    /**
     * проверка присутствия текста на странице
     *
     * @param text текст
     */
    @Когда("на странице присутствует текст {string}")
    public void textAppearOnThePage(String text) {
        WebChecks.textVisibleOnPage(text, null);
        LOGGER.info("на странице '{}' имеется текст '{}'", pageManager.getCurrentPage().name(), text);
    }

    /**
     * проверка отсутствия текста на странице
     *
     * @param text текст
     */
    @Когда("на странице отсутствует текст {string}")
    public void textVisibleOnPage(String text) {
        WebChecks.textAbsentOnPage(text, null);
        LOGGER.info("на странице '{}' отсутствует текст '{}'", pageManager.getCurrentPage().name(), text);
    }

    /**
     * ожидание появления текста на странице в течении некоторого времени
     *
     * @param text           текст
     * @param timeoutSeconds количество секунд
     */
    @Когда("подождать появления текста {string} в течение {int} секунд")
    public void waitUntilTextAppearOnPage(String text, int timeoutSeconds) {
        WebChecks.textVisibleOnPage(text, timeoutSeconds);
        LOGGER.info("на странице '{}' имеется текст '{}'", pageManager.getCurrentPage().name(), text);
    }

    /**
     * ожидание исчезновения текста на странице в течении некоторого времени
     *
     * @param text           текст
     * @param timeoutSeconds количество секунд
     */
    @Когда("подождать исчезновения текста {string} в течение {int} секунд")
    public void waitUntilTextAbsentOnPage(String text, int timeoutSeconds) {
        WebChecks.textAbsentOnPage(text, timeoutSeconds);
        LOGGER.info("на странице '{}' отсутствует текст '{}'", pageManager.getCurrentPage().name(), text);
    }

    /**
     * ожидание элемента на странице в течении некоторого времени
     *
     * @param elementName    наименование элемента
     * @param timeoutSeconds количество секунд
     */
    @Когда("подождать появления элемента {string} в течение {int} секунд")
    public void waitUntilElementIsVisibleOnPage(String elementName, int timeoutSeconds) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        WebChecks.elementVisibleOnPage(element, timeoutSeconds);
        LOGGER.info("на странице '{}' имеется элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }

    /**
     * проверка что на странице отображен элемент
     *
     * @param elementName наименование элемента
     */
    @Когда("на странице имеется элемент {string}")
    public void elementAppearOnThePage(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        WebChecks.elementVisibleOnPage(element, null);
        LOGGER.info("на странице '{}' имеется элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }

    /**
     * проверка что на странице отсуствует элемент
     *
     * @param elementName наименование элемента
     */
    @Когда("на странице отсутствует элемент {string}")
    public void elementAbsentOnPage(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        WebChecks.elementAbsentOnPage(element, null);
        LOGGER.info("на странице '{}' отсутствует элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }

    /**
     * проверка текущего url
     * <br/>можно начать написание url с переменной %{apiUrl}% или %{webUrl}%
     *
     * @param url часть или полный url (также может содержать переменные)
     */
    @Тогда("проверить что текущий url соответствует {string}")
    public void currentUrlEqualsExpected(String url) {
        WebChecks.urlEquals(url);
    }

    /**
     * проверка текущего url
     * <br/>можно начать написание url с переменной %{apiUrl}% или %{webUrl}%
     *
     * @param url часть url (также может содержать переменные)
     */
    @Тогда("проверить что текущий url содержит текст {string}")
    public void currentUrlContainsExpected(String url) {
        WebChecks.urlContains(url);
    }

    /**
     * Новая проверка
     */
    @Когда("получить все значения перевернутыми {string}")
    public void clickOnElement(String elementName) {

        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        List<String> reversedSmells = getReversedSmellValues(elementName);
       // reversedSmells.forEach(smell -> AllureHelper.attachTxt("Reversed Smell Value:", smell));

        for (String smell : reversedSmells) {
            AllureHelper.attachTxt("Reversed Smell Value",smell);
        }
    }

//    private List<String> getReversedSmellValues(String elementName) {
//        ElementsCollection smells = $$x("//input[@name='smell_type']/..");
//
//
//
//        // Извлечение текстовых значений элементов
//        List<String> smellsText = smells.texts();
//
//        // Изменение порядка элементов
//        Collections.reverse(smellsText);
//
//        return smellsText;
//    }
private List<String> getReversedSmellValues(String elementName) {
    ElementsCollection smells = $$x("//input[@name='smell_type']/..");

    // Извлечение текстовых значений элементов
    List<String> smellsText = smells.texts();

    // Переворачиваем каждую строку задом наперед
    List<String> reversedSmells = new ArrayList<>();
    for (String smell : smellsText) {
        String reversedSmell = reverseString(smell);
        reversedSmells.add(reversedSmell);
    }

    return reversedSmells;
}

    private String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }
}





