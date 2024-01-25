package Codingpractice8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class XpathOTpLoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://practice.expandtesting.com/otp-login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/main/div/div/div/div/div/div/form/div/input"))
                .sendKeys("practice@expandtesting.com");
        driver.findElement(By.xpath("/html/body/main/div/div/div/div/div/div/form/button"))
                .submit();
        String expectedtextTitle="Test Automation Practice: Working with OTP Verification";
        String currentTitle=driver.getTitle();
        if (expectedtextTitle.equalsIgnoreCase(currentTitle)) {
            System.out.println("OTP sent Succesfully");
        }
     driver.findElement(By.xpath("/html/body/main/div/div/div/div/div/div/form/div/input"))
             .sendKeys("214365");
        driver.findElement(By.xpath("/html/body/main/div/div/div/div/div/div/form/button"))
                .submit();
        String str1=driver.getCurrentUrl();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(str1));
        String currentUrl=driver.getCurrentUrl();
        if(currentUrl.equals(str1)){
            System.out.println("Logged is Successfully");
        }
        driver.quit();

        }
    }


