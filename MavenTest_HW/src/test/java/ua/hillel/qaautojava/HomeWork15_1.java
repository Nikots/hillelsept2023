package ua.hillel.qaautojava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork15_1 {

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "/Users/dima/IdeaProjects/hillelsept2023/MavenTest_HW/src/test/resources/chromedriver");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bstackdemo.com/");

        WebElement iphone12 = driver.findElement(By.xpath("*//div[2]/div[4]"));
        iphone12.click();
        WebElement iphone12mini = driver.findElement(By.xpath("*//div[3]/div[4]"));
        iphone12mini.click();
        WebElement checkout = driver.findElement(By.xpath("*//div[2]/div[2]/div[3]/div[3]"));
        WebElement bag = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]"));
        Assert.assertTrue(checkout.isEnabled());
        System.out.println(bag.getText());
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
}
