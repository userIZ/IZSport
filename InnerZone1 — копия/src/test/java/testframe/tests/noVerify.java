package testframe.tests;

import Helpers.DataBase;
import org.testng.Assert;
import org.testng.annotations.*;

public class noVerify extends DataBase {


    @Test
    public void testNonVerify() throws Exception {
        correctURL();
        entityName();
        title();
        firstName("first_name", "Test2");
        lastName();
        step1();
        address();
        city();
        state();
        country();
        zipCode();
        email("test@mail.ru");
        phone();
        step2();
        username();
        password();
        verifyPassword();
        Thread.sleep(2000);
        step3();
//        finalStep();
Assert.assertFalse(noVerify(driver));
    }
}