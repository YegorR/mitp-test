package ru.yegorr.mitptest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = ".//input[@id='text']")
    private WebElement queryLine;

    public void printQuery(String text) {
        queryLine.sendKeys(text);
    }
}
