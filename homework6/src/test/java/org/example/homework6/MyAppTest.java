package org.example.homework6;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAppTest {

    @Test
    public void myFirstTest() {
        System.out.println("This is my First Test");
    }

    @Test
    public void mySecondTest() {
        int result = 13;
        Assert.assertEquals(result, 13);
    }


}
