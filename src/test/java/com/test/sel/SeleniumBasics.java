package com.test.sel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumBasics {

    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver","./src/main/resources/drivers/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver","./src/main/resources/drivers/geckodriver.exe");
        //System.setProperty("webdriver.edge.driver", "./src/main/resources/drivers/msedgedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
