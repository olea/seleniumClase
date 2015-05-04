package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CambioContraseAIncorrecto {
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
  public void testCambioContraseAIncorrecto() throws Exception {
    driver.get("http://ualhmis15.cloudapp.net/");
    assertEquals("Home Page | Hmislogin", driver.getTitle());
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("user_username")).clear();
    driver.findElement(By.id("user_username")).sendKeys("user1");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("1234");
    driver.findElement(By.name("commit")).click();
    assertEquals("Protected page | Hmislogin", driver.getTitle());
    driver.findElement(By.linkText("Edit your account")).click();
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("1234");
    driver.findElement(By.id("user_password_confirmation")).clear();
    driver.findElement(By.id("user_password_confirmation")).sendKeys("1234");
    driver.findElement(By.id("user_current_password")).clear();
    driver.findElement(By.id("user_current_password")).sendKeys("1111");
    driver.findElement(By.name("commit")).click();
    assertEquals("Hmislogin", driver.getTitle());
    assertEquals("Current password is invalid", driver.findElement(By.cssSelector("#error_explanation > ul > li")).getText());
    driver.findElement(By.linkText("Sign out")).click();
    assertEquals("Home Page | Hmislogin", driver.getTitle());
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
