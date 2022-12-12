package com.test.sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

    public void testCheapestFlighBooking() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
        driver.findElement(By.xpath("//input[@data-cy='fromCity']")).click();
        driver.findElement(By.xpath("//input[@data-cy='fromCity']")).sendKeys("DEL");
        driver.findElement(By.xpath("//ul[@role='listbox']/li")).click();

        driver.findElement(By.xpath("//input[@data-cy='toCity']")).click();
        driver.findElement(By.xpath("//input[@data-cy='toCity']")).sendKeys("BLR");
        driver.findElement(By.xpath("//ul[@role='listbox']/li")).click();


        driver.findElement(By.xpath("//label[@for='departure']")).click();
        driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-disabled='false']")).click();
        driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-disabled='false'][2]")).click();

        driver.findElement(By.xpath("//a[text()='Search']")).click();





    }

}
