package testframe.tests;

import Helpers.DataBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NonData extends DataBase {
    @Test
    public void testNonData() throws Exception{
        correctURL();
        step1();
        Assert.assertFalse(activeStep(driver));
    }
}
