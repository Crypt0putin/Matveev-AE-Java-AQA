package org.STC2306;

import java.time.LocalDate;

public class CactusWatering {
    public static void main(String... args) {
        LocalDate lastWateringDate = LocalDate.of(2021, 9, 1); // пример даты последнего полива
        LocalDate currentDate = LocalDate.now();
        String message;

        if (currentDate.getMonthValue() >= 12 || currentDate.getMonthValue() <= 2) {
            if (currentDate.minusMonths(1).isAfter(lastWateringDate)) {
                message = " актус нужно полить раз в мес€ц зимой. ѕоследний полив был " + lastWateringDate.plusMonths(1);
            } else {
                message = " актус не нужно поливать зимой";
            }
        } else if (currentDate.getMonthValue() <= 5 || currentDate.getMonthValue() >= 9) {
            if (currentDate.minusWeeks(1).isAfter(lastWateringDate)) {
                message = " актус нужно полить раз в неделю весной и осенью. ѕоследний полив был " + lastWateringDate.plusWeeks(1);
            } else {
                message = " актус не нужно поливать весной и осенью";
            }
        } else {
            int humidity = Sensor.getHumidity();
            if (humidity < 30) {
                message = " актус нужно полить, так как влажность воздуха ниже 30%";
            } else if (currentDate.minusDays(2).isAfter(lastWateringDate)) {
                message = " актус нужно полить, так как прошло более двух дней с последнего полива";
            } else {
                message = " актус не нужно поливать летом";
            }
        }

        System.out.println(message);
    }
}