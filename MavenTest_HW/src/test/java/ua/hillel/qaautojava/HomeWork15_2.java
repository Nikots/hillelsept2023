package ua.hillel.qaautojava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork15_2 {
    @Test
    public void addingAndDeletingItem() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bstackdemo.com/");

        List<WebElement> iphones = driver.findElements(By.className("shelf-item__title"));
        for (int i = 0; i < iphones.size(); i++) {
            String name = iphones.get(i).getText();

            if (name.equals("iPhone 12")) {
                driver.findElements(By.className("shelf-item__buy-btn")).get(i).click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
                wait.until(ExpectedConditions.elementToBeClickable(By.className("shelf-item__del")));

                driver.findElement(By.xpath("//*[@class = 'shelf-item__del']")).click();
                WebElement bag = driver.findElement(By.className("float-cart__shelf-container"));
                Assert.assertTrue(bag.getText().contains("Add some products in the bag\n" +
                        ":)"), "The bag isn't empty");

            }
        }
        driver.quit();
    }
}