package selenidTests;

import Helpers.ParametersHelper;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends ParametersHelper {
    @Test
    public void correctLoginAdmin() {
        getOpen();
        $(By.id("inputEmail")).setValue("smladmin");
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();

        $(By.cssSelector("div.header")).shouldHave(text("SELECT ENTITY"));

    }

    @Test
    public void correctLoginUser() {
        getOpen();
        $(By.id("inputEmail")).setValue("58username0.133928369989476");
        $(By.id("inputPassword")).setValue("qwerty").pressEnter();

        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-innerzone-profile/iz-profile/div/iz-profile-info-child/div/div[1]/div/div[1]")).shouldHave(text("COMMUNICATION PROJECTION"));

    }

    @Test
    public void correctLoginCoach() {
        getOpen();
        $(By.id("inputEmail")).setValue("quaidc");
        $(By.id("inputPassword")).setValue("qwerty").pressEnter();

        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/app-sports-management/app-dashboard-title/div[1]")).shouldHave(text("SPORTS MANAGEMENT"));
    }

    @Test
    public void correctLoginCapslock() {
        getOpen();
        $(By.id("inputEmail")).setValue("SMLADMIN");
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();

        $(By.cssSelector("div.header")).shouldHave(text("SELECT ENTITY"));

    }

    @Test
    public void incorrectLoginCapslock() {
        getOpen();
        $(By.id("inputEmail")).setValue("SMLADMIN");
        $(By.id("inputPassword")).setValue("SMLADMIN").pressEnter();

        $(By.cssSelector("div.error")).shouldHave(text("Wrong username or password"));

    }

    @Test
    public void incorrectLoginCapslockPassword() {
        getOpen();
        $(By.id("inputEmail")).setValue("smladmin");
        $(By.id("inputPassword")).setValue("SMLADMIN").pressEnter();

        $(By.cssSelector("div.error")).shouldHave(text("Wrong username or password"));

    }

    @Test
    public void incorrectPassword() {
        getOpen();
        $(By.id("inputEmail")).setValue("smladmin");
        $(By.id("inputPassword")).setValue("smladmn").pressEnter();

        $(By.cssSelector("div.error")).shouldHave(text("Wrong username or password"));

    }

    @Test
    public void incorrectLogin() {
        getOpen();
        $(By.id("inputEmail")).setValue("smladmn");
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();

        $(By.cssSelector("div.error")).shouldHave(text("Wrong username or password"));
    }

    @Test
    public void nonData() {
        getOpen();
        $(By.id("inputEmail")).setValue("");
        $(By.id("inputPassword")).setValue("").pressEnter();

        $(By.cssSelector("div.error")).shouldNot(text("Wrong username or password"));
        $(By.cssSelector("div.header")).shouldNot(text("SELECT ENTITY"));
    }

    @Test
    public void nonLogin() {
        getOpen();
        $(By.id("inputEmail")).setValue("");
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();

        $(By.cssSelector("div.error")).shouldNot(text("Wrong username or password"));
        $(By.cssSelector("div.header")).shouldNot(text("SELECT ENTITY"));
    }

    @Test
    public void nonPassword() {
        getOpen();
        $(By.id("inputEmail")).setValue("smladmin");
        $(By.id("inputPassword")).setValue("").pressEnter();

        $(By.cssSelector("div.error")).shouldNot(text("Wrong username or password"));
        $(By.cssSelector("div.header")).shouldNot(text("SELECT ENTITY"));
    }
}
