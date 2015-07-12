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

public class FindFilm extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testFindFilm() throws Exception {
    // type | id=q | game
    driver.findElement(By.id("q")).clear();
    driver.findElement(By.id("q")).sendKeys("game");
    // sendKeys | id=content | \13
    driver.findElement(By.id("content")).sendKeys("\\13");
    // click | css=img[alt="Big game"] | 
    driver.findElement(By.cssSelector("img[alt=\"Big game\"]")).click();
    // assertElementPresent | css=img[alt="Big game"] | 
    assertTrue(isElementPresent(By.cssSelector("img[alt=\"Big game\"]")));
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