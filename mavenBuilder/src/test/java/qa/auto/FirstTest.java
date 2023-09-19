package qa.auto;

import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void simpleTest(){
        System.out.println(System.getProperty("showMessage"));
    }
}
