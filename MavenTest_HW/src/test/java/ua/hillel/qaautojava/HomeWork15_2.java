package ua.hillel.qaautojava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork15_2 {
    @Test
    public void addingAndDeletingItem() {
        System.setProperty("webdriver.chrome.driver", "/Users/dima/IdeaProjects/hillelsept2023/MavenTest_HW/src/test/resources/chromedriver");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bstackdemo.com/");


        WebElement iphone12mini = driver.findElement(By.xpath("*//div[3]/div[4]"));
        iphone12mini.click();
        driver.findElement(By.xpath("//*[@class = 'float-cart__shelf-container']")).getText();
        driver.findElement(By.xpath("//*[@class = 'shelf-item__del']")).click();
        WebElement bag = driver.findElement(By.className("float-cart__shelf-container"));
        Assert.assertTrue(bag.getText().contains("Add some products in the bag\n" +
                ":)"), "The bag isn't empty");

        driver.quit();
    }
}