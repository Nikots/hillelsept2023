package ua.hillel.qaautojava;

import org.testng.annotations.Test;

public class Task6 {

    @Test
    public void TestNumberOne()
    {
        double L = 10.5;
        double H = 15;
        double S = (L * L);
        double V = ((S * H)/3.0);
        System.out.println("Если длина пирамиды = "+L+", а высота = "+H+", то объём пирамиды = "+V);
    }
}
