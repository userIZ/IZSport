package Helpers;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Instant;

public class AssertData {
    public static boolean checkIfCheckBoxDisplayed(WebDriver driver) {
        try {
            WebElement element = driver.findElement(By.name("verify"));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean activeStep(WebDriver driver) {
        try {
            WebElement element = driver.findElement(By.cssSelector("div.step active"));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public static boolean noVerify(WebDriver driver) {
        try {
            WebElement element = driver.findElement(By.cssSelector("div.label"));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean login(WebDriver driver) {
        try {
            WebElement element = driver.findElement(By.id("inputEmail"));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected String generateRandomUsername() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getUsername();
    }

    protected String generateRandomName() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getFirstName();
    }
    protected String generateEmail() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getEmail();
    }
    Instant instant = Instant.now();
    long timeStampSeconds = instant.getEpochSecond();
}
