package ru.yegorr.mitptest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;

public class SearchPage {

    private final WebDriver webDriver;

    public SearchPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public List<Integer> getPositionOfAuthor(String searchQuery) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }

        List<WebElement> items = webDriver.findElements(By.className("product-card"));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < items.size(); ++i) {
            WebElement item = items.get(i);
            WebElement author = item.findElement(By.className("product-card__author"));
            if (author != null && author.getText() != null && author.getText().toLowerCase().contains(searchQuery.toLowerCase())) {
                result.add(i);
            }
        }

        return result;
    }
}
