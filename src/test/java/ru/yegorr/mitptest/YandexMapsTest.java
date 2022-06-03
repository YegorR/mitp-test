package ru.yegorr.mitptest;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static ru.yegorr.mitptest.Data.*;

public class YandexMapsTest {

    private final static String URL = "https://yandex.ru/maps";

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver",
                YandexMapsTest.class.getClassLoader().getResource("geckodriver.exe").getPath());

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void positiveTest() throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='button _view_air _size_medium']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@class='button _view_primary _ui _size_medium _link']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='passp-field-login']")).sendKeys(LOGIN);
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='passp:sign-in']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='passp-field-passwd']")).sendKeys(PASSWORD);
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='passp:sign-in']")).click();
        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.xpath("//nav[@class='map-controls']")).isDisplayed());
    }

    @Test
    public void negativeTest() throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='button _view_air _size_medium']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@class='button _view_primary _ui _size_medium _link']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='passp-field-login']")).sendKeys(LOGIN);
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='passp:sign-in']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='passp-field-passwd']")).sendKeys(WRONG_PASSWORD);
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='passp:sign-in']")).click();
        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Неверный пароль']")).isDisplayed());
    }
}
