package ru.yegorr.mitptest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ChitaiGorodTest {

    private final static String URL = "https://chitai-gorod.ru";

    private static MainPage mainPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver",
                ChitaiGorodTest.class.getClassLoader().getResource("geckodriver.exe").getPath());

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(URL);

        mainPage = new MainPage(driver);
    }

    @Test
    public void test() throws Exception {
        mainPage.printQuery("Война и мир");
    }
}
