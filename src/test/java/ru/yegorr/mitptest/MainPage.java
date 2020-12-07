package ru.yegorr.mitptest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(id = "text")
    private WebElement queryLine;

    public void printQuery(String text) {
        queryLine.sendKeys(text);
    }
}
