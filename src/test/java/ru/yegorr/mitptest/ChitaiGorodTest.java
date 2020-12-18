package ru.yegorr.mitptest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChitaiGorodTest {

    private final static String URL = "https://chitai-gorod.ru";

    private final static String QUERY = "Преступление и наказание";

    private final static String AUTHOR = "Достоевский";

    private static MainPage mainPage;

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver",
                ChitaiGorodTest.class.getClassLoader().getResource("geckodriver.exe").getPath());

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.get(URL);

        mainPage = new MainPage(driver);
    }

    @Test
    public void test() throws Exception {
        mainPage.printQuery(QUERY);
        SearchPage searchPage = new SearchPage(driver);
        List<Integer> result  = searchPage.getPositionOfAuthor(AUTHOR);
        result.stream().forEachOrdered((index) -> System.out.println("#" + index));
    }
}
