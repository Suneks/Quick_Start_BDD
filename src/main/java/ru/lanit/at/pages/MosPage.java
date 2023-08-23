package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
@Name(value = "mos.ru")
public class MosPage extends WebPage {
    // Для проверки элементов задом наперед
    @Name("Запахи")
    private SelenideElement smells
            = $x("//input[@name='smell_type']");
    // 1-й Вопрос
    @Name("опрос о качестве воздуха в Москве")
    private SelenideElement airQualitySurvey
            = $x("//*[contains(text(),'Пройти опрос о качестве воздуха в Москве')]");
    @Name("поле ввода")
    private SelenideElement searchField = $x("//input[@id='address-autocomplete']");
    @Name("адрес")
    private SelenideElement address = $x("//*[contains(text(),'город Москва, Ленинский проспект, дом 61/1, строение 1')]");
    // Второй вопрос
    @Name("второй вопрос")
    private SelenideElement secondQquestion = $x("//*[contains(text(),'Вопрос 2/5')]");
    @Name("характер запаха")
        private SelenideElement valueType = $x("//input[contains(@value, 'Гарь')]/..");
    // Третий вопрос
    @Name("третий вопрос")
    private SelenideElement thirdQuestion = $x("//*[contains(text(),'Вопрос 3/5')]");
    @Name("поле календарь")
    private SelenideElement calenderField = $x("//input[@id='report-date']");
    @Name("виджет календарь")
    private SelenideElement calenderDaySelection = $x("//div[@id='ui-datepicker-div']");
    @Name("выбор дня календаря")
    private SelenideElement calenderDay = $x("//a[@class='ui-state-default'][contains(text(), '15')]");
    @Name("выбор периода")
    private SelenideElement periodField = $x("//div[contains(text(), 'Выберите временные отрезки')]");
    @Name("виджет выбор периода")
    private SelenideElement periodSelection = $x("//div[@class='helper'][contains(text(), 'Не более 2 вариантов')]");
    @Name("чекбокс выбор периода")
    private SelenideElement periodCheckbox = $x("//input[contains(@data-label, '00:00 - 06:00')]/..");
    // Четвертый вопрос
    @Name("четвертый вопрос")
    private SelenideElement fourthQuestion = $x("//*[contains(text(),'Вопрос 4/5')]");
    @Name("периодичность каждый день")
    private SelenideElement periodicityCheckbox = $x("//input[contains(@value, 'Каждый день')]/..");


    // кнопки для каждого вопроса
    @Name("кнопка ответить 1")
    private SelenideElement btnForFirstQuestion = $x("//div[@id='quiz-page-id-0']//button");
    @Name("кнопка ответить 2")
    private SelenideElement btnForSecondQuestion =
            $x("//div[@id='quiz-page-id-1']//button");
    @Name("кнопка ответить 3")
    private SelenideElement btnForThirdQuestion =
            $x("//div[@id='quiz-page-id-2']//button");
    @Name("кнопка ответить 4")
    private SelenideElement btnForFourthQuestion =
            $x("//div[@id='quiz-page-id-3']//button");
}
