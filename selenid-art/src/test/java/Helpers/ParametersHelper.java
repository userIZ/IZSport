package Helpers;

import org.junit.Before;
import org.junit.BeforeClass;

import java.lang.reflect.Field;

import static com.codeborne.selenide.Selenide.open;

public class ParametersHelper {
    public void getOpen() {
        open("http://sports.innerzone.local/#/login");
    }


}
