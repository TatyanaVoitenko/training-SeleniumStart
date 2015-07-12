package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddFilm extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testAddFilm() throws Exception {
    // open | /php4dvd/ | 
    driver.get(baseUrl + "/php4dvd/");
    // click | css=img[alt="Add movie"] | 
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    // type | name=name | My First Film
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("My First Film");
    // type | name=aka | hfffg
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("hfffg");
    // type | name=year | 2015
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("2015");
    // type | name=duration | 1000
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys("1000");
    // type | name=rating | 10
    driver.findElement(By.name("rating")).clear();
    driver.findElement(By.name("rating")).sendKeys("10");
    // click | id=own_no | 
    driver.findElement(By.id("own_no")).click();
    // click | id=seen_no | 
    driver.findElement(By.id("seen_no")).click();
    // click | id=loaned_no | 
    driver.findElement(By.id("loaned_no")).click();
    // click | id=submit | 
    driver.findElement(By.id("submit")).click();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}