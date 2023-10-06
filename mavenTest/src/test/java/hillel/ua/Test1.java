package hillel.ua;

import org.testng.annotations.Test;

public class Test1 {

    @Test
    public void firstTest() {
        System.out.println("Test 1");
        System.out.println(System.getProperty("url"));
    }

    @Test
    public void secondTest() {
        System.out.println("Test 2");
        System.out.println(System.getProperty("my.value"));


    }
}
