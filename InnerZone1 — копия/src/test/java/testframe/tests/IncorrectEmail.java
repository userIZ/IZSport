package testframe.tests;

import Helpers.DataBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncorrectEmail extends DataBase {
    @Test
    public void testIncorrectMail() throws Exception {
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
        email("test@mail.m");
        phone();
        step2();
        Assert.assertFalse(checkIfCheckBoxDisplayed(driver));//comment

    }
}