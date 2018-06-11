package com.greenfoxacademy.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeleniumApplicationTests {

  @Test
  public void checkIfWebPageTitleEqualsGoogle() {
    FirefoxOptions options = new FirefoxOptions();
    options.setHeadless(true);
    WebDriver driver = new FirefoxDriver(options);
    driver.get("http://google.com");
    Assert.assertTrue(driver.getTitle().equals("Google"));
    driver.close();
  }

}
