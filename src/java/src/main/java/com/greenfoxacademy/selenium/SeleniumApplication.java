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

    ChromeOptions options = new ChromeOptions();
    List<String> chromeSetup = new ArrayList<>(Arrays.asList(
            "--silent-launch",
            "--no-startup-window",
            "no-sandbox",
            "headless"));
    options.addArguments(chromeSetup);

    WebDriver driver = new ChromeDriver(options);
    driver.get("https://google.com");
    System.out.println("Page title: " + driver.getTitle());

    driver.findElement(By.name("q")).sendKeys("java junior developer job");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

    Thread.sleep(3000);

    System.out.println("Total results: " + driver.findElement(By.id("resultStats")).getText());

    driver.quit();
  }
}
