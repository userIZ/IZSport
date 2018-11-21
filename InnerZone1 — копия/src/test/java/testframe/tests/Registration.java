package testframe.tests;

import Helpers.DataBase;
import org.testng.Assert;
import org.testng.annotations.*;

public class Registration extends DataBase {


    @Test
    public void testRegistration() throws Exception {
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
        email(generateEmail());
        phone();
        step2();
        username();
        password();
        step3();
        verifyPassword();
        verify();
        finalStep();

        Assert.assertTrue(login(driver));
    }


}
