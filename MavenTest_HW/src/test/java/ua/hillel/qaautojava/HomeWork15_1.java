package ua.hillel.qaautojava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class HomeWork15_1 {

    @Test
    public void addingItemsAndCartChecking() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bstackdemo.com/");
        String[] items = {"iPhone 12", "iPhone 12 Mini"};
        List<WebElement> elements = driver.findElements(By.className("shelf-item__title"));
        for (int i = 0; i < elements.size(); i++) {
            String name = elements.get(i).getText();
            List list = Arrays.asList(items);
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
