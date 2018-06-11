package com.greenfoxacademy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(SeleniumApplication.class, args);

    // System.setProperty("webdriver.chrome.driver", ".driver/chromedriver");

    // Set Chrome Headless mode true
    FirefoxOptions options = new FirefoxOptions();
    options.setHeadless(true);

    // Instantiate Web Driver
    WebDriver driver = new FirefoxDriver(options);
    driver.get("https://google.com");
    System.out.println("Page title: " + driver.getTitle());

    // Search on Google
    driver.findElement(By.name("q")).sendKeys("java junior developer job");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

/*
    // Another solution
    WebElement searchButton = driver.findElement(By
            .name("btnK"));

    Actions actions = new Actions(driver);

    actions.moveToElement(searchButton).perform();

    WebElement searchField = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

    searchField.sendKeys("java junior developer job");

    searchField.submit();
*/

    // Wait 3 seconds
    Thread.sleep(3000);

    // Print out results
    System.out.println("Total results: " + driver.findElement(By.id("resultStats")).getText());

    // Close the browser
    driver.quit();
  }


}

