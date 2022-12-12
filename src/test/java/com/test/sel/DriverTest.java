package com.test.sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import supplier.DriverFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DriverTest {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browsers")
    public void setDriver(@Optional("chrome") String browser){
        this.driver= DriverFactory.getDriver(browser);
    }

    @Test
    public void  googleTest(){
       this.driver.get("https://google.com");
       List<Integer> list = new ArrayList<>();
        Predicate<WebElement> removeS = s ->s.getText().toLowerCase().contains("s");
        Predicate<WebElement> removeAllSAndBlank = removeS.or(s->s.getText().trim().length()==0);
        List<WebElement> elements = this.driver.findElements(By.tagName("a"));
        System.out.println("Size before removing:: "+elements.size());
        elements.removeIf(removeAllSAndBlank);
        System.out.println("Size After Removing:: "+elements.size());
        elements.forEach(s-> System.out.println(s.getText()));
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
