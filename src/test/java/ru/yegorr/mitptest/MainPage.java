package ru.yegorr.mitptest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = ".//input[@name='q']")
    private WebElement queryLine;

    public void printQuery(String text) throws InterruptedException {
        queryLine.sendKeys(text);
        queryLine.sendKeys(Keys.ENTER);
    }
}
