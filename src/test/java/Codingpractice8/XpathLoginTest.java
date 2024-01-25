package Codingpractice8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class XpathLoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://practice.expandtesting.com/login");
        driver.manage().window().maximize();
        WebElement e1=driver.findElement(By.xpath("/html/body/main/div/div/div/div/div/div[1]/form/div/div[1]/input"));
        e1.sendKeys("practice");
        WebElement e2=driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div/div/form/div/div[2]/input"));
        e2.sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("/html/body/main/div/div/div/div/div/div/form/button")).submit();
   String str="https://practice.expandtesting.com/secure";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe(str));
        String currenturl=driver.getCurrentUrl();
        if(currenturl.equals(str)){
            System.out.println("Logged is Successfully");
            System.out.println(driver.getCurrentUrl());
        }
        driver.quit();
    }
}
