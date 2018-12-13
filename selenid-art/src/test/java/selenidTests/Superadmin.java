package selenidTests;

import com.codeborne.selenide.Condition;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Superadmin {

    @Before
    public void OpenRegistration() {
        open("http://sports.innerzone.local/#/login");
        $(By.id("inputEmail")).setValue("smladmin");
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();

        $(By.xpath("/html/body/app-root/app-dashboard/div/app-navbar/div/span/app-current-entity/modal/div/div/div/div[2]/modal-content/div[2]/div[1]")).click();
    }

    @Test
    public void aCreateSuperadmin(){

        $(By.xpath("//*[@id=\"tableRoot\"]/span/app-table-columns/div/app-table-column/div/div/div[2]/app-table-filter/div/svg-icon")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[1]/dropdown/div/div[1]/label")).click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/div/app-dashboard-title/div[2]/div/iz-sa-form/form/div/div/iz-form-dynamic-content/div/iz-form-field[1]/dropdown/div/div[2]/div[1]/span/div/span")).click();
        $(By.id("first_name")).setValue("Smith");
        $(By.id("last_name")).setValue("John");
        $(By.id("email")).setValue("email@test1.ru");
        $(By.id("username")).setValue("johnsmith");
        $(By.id("password")).setValue("qwerty").pressEnter();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows")).shouldHave(text("Smith John"));
    }
    @Test
    public void bEditSuperadmin(){
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows")).shouldHave(text("Smith John"));
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows/div/app-table-row[16]/div/div/div/div/div/app-ellipsis-component/button")).click();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows/div/app-table-row[16]/div/div/div/div/app-dropdown-menu/div/div/app-dropdown-menu-item[1]/div")).click();
        $(By.id("first_name")).setValue("Smithy");
        $(By.id("last_name")).setValue("Johney");
        $(By.id("email")).setValue("email@test1.ru");
        $(By.id("username")).setValue("johnsmith");
        $(By.id("password")).setValue("qwerty").pressEnter();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows")).shouldHave(text("Smithy Johney"));
    }
    @Test
    public void cDeleteSuperadmin(){
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows")).shouldHave(text("Smithy Johney"));
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows/div/app-table-row[16]/div/div/div/div/div/app-ellipsis-component/button")).click();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows/div/app-table-row[16]/div/div/div/div/app-dropdown-menu/div/div")).find("#tableRoot > span > span > app-table-rows > div > app-table-row:nth-child(16) > div > div > div > div > app-dropdown-menu > div > div > app-dropdown-menu-item:nth-child(2) > div").click();
        $(By.xpath("/html/body/app-root/app-dashboard/div/div/div/iz-sa-page/modal/div/div/div/div[2]/modal-content/div[3]/button")).click();
        $(By.xpath("//*[@id=\"tableRoot\"]/span/span/app-table-rows")).shouldNot(text("Smithy Johney"));
    }

}
