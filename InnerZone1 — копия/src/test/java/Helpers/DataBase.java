package Helpers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class DataBase extends UserActions{
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    protected void correctURL() {
        driver.get("http://sports.innerzone.local/#/login");
        driver.get("http://sports.innerzone.local/#/registration");
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        init();

    }

    private void init() {
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
           stop();
    }

    private void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


}