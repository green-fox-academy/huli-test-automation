package com.greenfoxacademy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SeleniumApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(SeleniumApplication.class, args);

/**
    // If you have problem adjusting browser's driver
    System.setProperty("webdriver.chrome.driver", ".driver/chromedriver");
*/

    // Start chrome headless mode
    ChromeOptions options = new ChromeOptions();
    List<String> chromeSetup = new ArrayList<>(Arrays.asList(
            "--silent-launch",
            "--no-startup-window",
            "no-sandbox",
            "headless"));
    options.addArguments(chromeSetup);

    // Instantiate Web Driver
    WebDriver driver = new ChromeDriver(options);
    driver.get("https://google.com");
    System.out.println("Page title: " + driver.getTitle());

    // Search on Google
    driver.findElement(By.name("q")).sendKeys("java junior developer job");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

/**
    // Another approach with the same result
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
