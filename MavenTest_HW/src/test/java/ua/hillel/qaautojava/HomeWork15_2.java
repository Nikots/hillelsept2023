package ua.hillel.qaautojava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork15_2 {
    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "/Users/dima/IdeaProjects/hillelsept2023/MavenTest_HW/src/test/resources/chromedriver");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bstackdemo.com/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement iphone12mini = driver.findElement(By.xpath("*//div[3]/div[4]"));
        iphone12mini.click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]")).getText());
        System.out.println();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[1]")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]")).getText());
    }
}