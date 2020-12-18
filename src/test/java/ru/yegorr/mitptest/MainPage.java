package ru.yegorr.mitptest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = ".//input[@name='q']")
    private WebElement queryLine;

    public void printQuery(String text) throws InterruptedException {
        queryLine.sendKeys(text);
        queryLine.sendKeys(Keys.ENTER);
    }
}
