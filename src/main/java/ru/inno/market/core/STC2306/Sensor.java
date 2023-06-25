package org.STC2306;

import java.util.Random;

public class Sensor {
    private int humidity;

     public static int getHumidity() {
         Random random = new Random();
         return random.nextInt(100);
    }
}
