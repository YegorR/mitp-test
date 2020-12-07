package ru.yegorr.mitptest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GoogleTest {

    private final static String URL = "https://yandex.ru";

    private static MainPage mainPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver",
                GoogleTest.class.getClassLoader().getResource("geckodriver.exe").getPath());

        WebDriver driver = new FirefoxDriver();
        driver.manage().
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);

        mainPage = new MainPage(driver);
    }

    @Test
    public void test() {
        mainPage.printQuery("Хочу персиков");
    }
}
