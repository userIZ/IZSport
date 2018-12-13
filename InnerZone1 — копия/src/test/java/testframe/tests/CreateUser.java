package testframe.tests;

import java.lang.annotation.Native;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateUser {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test (enabled = true)
  public void testCreateUser() throws Exception {
    driver.get("http://sports.innerzone.local/#/login");
    driver.findElement(By.id("inputEmail")).click();
    driver.findElement(By.id("inputPassword")).clear();
    driver.findElement(By.id("inputPassword")).sendKeys("smladmin");
    driver.findElement(By.id("inputEmail")).clear();
    driver.findElement(By.id("inputEmail")).sendKeys("smladmin");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='password'])[1]/following::button[1]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SELECT ENTITY'])[1]/following::div[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='smladmins asd'])[1]/following::div[4]")).click();
    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='smladmins last_name'])[1]/following::label[1]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Season'])[1]/following::label[1]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='- No Selection'])[1]/following::span[3]")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("app-table-filter.inceremnt > div.table-filter-btn > svg-icon > svg")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Position'])[1]/following::label[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Defender'])[1]/following::span[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[1]/following::label[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='- No Selection'])[1]/following::span[3]")).click();
    driver.findElement(By.name("first_name")).click();
    driver.findElement(By.name("first_name")).clear();
    driver.findElement(By.name("first_name")).sendKeys("User1");
    driver.findElement(By.name("last_name")).click();
    driver.findElement(By.name("last_name")).clear();
    driver.findElement(By.name("last_name")).sendKeys("User2");
    driver.findElement(By.name("number")).click();
    driver.findElement(By.name("number")).clear();
    driver.findElement(By.name("number")).sendKeys("56");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("mail67@mail.ru");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("useruser12");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("qwerty");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='No'])[1]/following::button[1]")).click();
  }

  @AfterClass(alwaysRun = true)
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
