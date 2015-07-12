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

public class FillUserForm extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testFillUserForm() throws Exception {
    // click | link=User management | 
    driver.findElement(By.linkText("User management")).click();
    // type | id=username | ElenaV
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("ElenaV");
    // type | name=email | elena@email.com
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("elena@email.com");
    // type | id=password | 111111
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("111111");
    // type | id=password2 | 111111
    driver.findElement(By.id("password2")).clear();
    driver.findElement(By.id("password2")).sendKeys("111111");
    // select | name=permission | label=Editor
    new Select(driver.findElement(By.name("permission"))).selectByVisibleText("Editor");
    // click | name=submit | 
    driver.findElement(By.name("submit")).click();
    // assertElementPresent | link=ElenaV | 
    assertTrue(isElementPresent(By.linkText("ElenaV")));
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