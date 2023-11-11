package ua.hillel.qaautojava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class HomeWork15_1 {

    @Test
    public void addingItemsAndCartChecking() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bstackdemo.com/");

        String[] names = {"iPhone 12 Mini", "iPhone 12"};

        List<WebElement> phones = driver.findElements(By.xpath("//*[@class = 'shelf-item__title']"));
        for (int i = 0; i < phones.size(); i++) {

            String name = phones.get(i).getText();
            List list = Arrays.asList(names);
            if (list.contains(name)) {
                driver.findElements(By.className("shelf-item__buy-btn")).get(i).click();
                continue;
            }
            WebElement checkout = driver.findElement(By.className("buy-btn"));
            WebElement bag = driver.findElement(By.className("float-cart__shelf-container"));
            Assert.assertTrue(checkout.isEnabled());
            Assert.assertTrue(bag.getText().contains("iPhone 12\n" +
                    "Apple\n" +
                    "Quantity: 1\n" +
                    "$ 799.00\n" +
                    "-+\n" +
                    "iPhone 12 Mini\n" +
                    "Apple\n" +
                    "Quantity: 1\n" +
                    "$ 699.00\n" +
                    "-+"), "Another items");

        }
        driver.quit();
    }
}

