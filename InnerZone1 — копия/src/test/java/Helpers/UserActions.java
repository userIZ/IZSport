package Helpers;

import org.openqa.selenium.*;

public class UserActions extends AssertData{
    protected WebDriver driver;
    private boolean acceptNextAlert = true;

    protected void nextStep(String s) {
        driver.findElement(By.xpath(s)).click();
    }

    protected void lastName() {
        driver.findElement(By.name("last_name")).click();
        driver.findElement(By.name("last_name")).clear();
        driver.findElement(By.name("last_name")).sendKeys("Test3");
    }

    protected void firstName(String first_name, String test2) {
        driver.findElement(By.name(first_name)).click();
        driver.findElement(By.name(first_name)).clear();
        driver.findElement(By.name(first_name)).sendKeys(test2);
    }

    protected void title() {
        nextStep("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[1]/following::label[1]");
        nextStep("(.//*[normalize-space(text()) and normalize-space(.)='- No Selection'])[1]/following::div[3]");
    }

    protected void entityName() {
        driver.findElement(By.name("entity_name")).click();
        driver.findElement(By.name("entity_name")).clear();
        driver.findElement(By.name("entity_name")).sendKeys(generateRandomName() + timeStampSeconds);
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

    protected void step3() {
        nextStep("(.//*[normalize-space(text()) and normalize-space(.)='Step 3'])[1]/following::form[1]");
    }

    protected void step2() {
        nextStep("(.//*[normalize-space(text()) and normalize-space(.)='Step Back'])[1]/following::button[1]");
    }

    protected void step1() {
        nextStep("(.//*[normalize-space(text()) and normalize-space(.)='Last Name'])[1]/following::button[1]");
    }

    protected void finalStep() throws InterruptedException {
        //
        step2();

        nextStep("(.//*[normalize-space(text()) and normalize-space(.)='Step 3'])[1]/following::button[1]");

    }

    protected void verify() {
        driver.findElement(By.name("verify")).click();
    }

    protected void verifyPassword() {
        driver.findElement(By.name("verifyPassword")).click();
        driver.findElement(By.name("verifyPassword")).clear();
        driver.findElement(By.name("verifyPassword")).sendKeys("qwerty");
    }

    protected void password() {
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("qwerty");
    }

    protected void username() {
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(generateRandomUsername() + timeStampSeconds);
    }

    protected void phone() {
        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("89182345678");
    }

    protected void email(String email) {
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);
    }

    protected void zipCode() {
        driver.findElement(By.name("zip_code")).click();
        driver.findElement(By.name("zip_code")).clear();
        driver.findElement(By.name("zip_code")).sendKeys("test8");
    }

    protected void country() {
        driver.findElement(By.name("country")).click();
        driver.findElement(By.name("country")).clear();
        driver.findElement(By.name("country")).sendKeys("test7");
    }

    protected void state() {
        driver.findElement(By.name("state")).click();
        driver.findElement(By.name("state")).clear();
        driver.findElement(By.name("state")).sendKeys("test6");
    }

    protected void city() {
        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys("test5");
    }

    protected void address() {
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys("test4");
    }
}
