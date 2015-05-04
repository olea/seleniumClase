package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ForgotyourpasswordCorrecto {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://ualhmis15.cloudapp.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testForgotyourpasswordCorrecto() throws Exception {
    driver.get("http://ualhmis15.cloudapp.net/");
    assertEquals("Home Page | Hmislogin", driver.getTitle());
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.linkText("Forgot your password?")).click();
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("ismael@olea.org");
    driver.findElement(By.name("commit")).click();
    assertEquals("Hmislogin", driver.getTitle());
    assertEquals("You will receive an email with instructions on how to reset your password in a few minutes.", driver.findElement(By.id("flash_notice")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
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
