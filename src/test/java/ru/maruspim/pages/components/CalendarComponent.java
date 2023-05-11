package ru.maruspim.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    // Selenide elements / locator / etc
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");
    // Actions
    public void setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        yearSelect.selectOption(year);
        monthSelect.selectOption(month);
        String dayPickerLocator = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
        $(dayPickerLocator).click();

    }
}
