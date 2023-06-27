package org.STC2306;

import java.time.LocalDate;
import java.util.Scanner;

public class CactusWatering {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год даты последнего полива: ");
        int year = scanner.nextInt();

        System.out.print("Введите месяц (число от 1 до 12) даты последнего полива: ");
        int month = scanner.nextInt();

        System.out.print("Введите день (число от 1 до 31) даты последнего полива: ");
        int day = scanner.nextInt();

        LocalDate lastWateringDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        String message;

        if (currentDate.getMonthValue() == 12 || currentDate.getMonthValue() <= 2) {
            if (currentDate.minusMonths(1).isAfter(lastWateringDate)) {
                message = "Кактус нужно полить. Прошло больше месяца с даты последнего полива" + "(" + lastWateringDate + ").";
            } else {
                message = "Кактус не нужно поливать. Прошло меньше месяца с даты последнего полива" + "(" + lastWateringDate + ").";
            }
        } else if ((currentDate.getMonthValue() <= 5 || currentDate.getMonthValue() >= 9)) {
            message = "Кактус нужно полить. Прошло больше недели с даты последнего полива " + "(" + lastWateringDate + ").";

        } else {
            int humidity = Sensor.getHumidity();
            if (humidity < 30) {
                message = "Кактус нужно полить, так как влажность воздуха ниже 30% " + "(" + humidity + "%). Дата последнего полива: "  + lastWateringDate + ".";
            } else if (currentDate.minusDays(2).isAfter(lastWateringDate)) {
                message = "Кактус нужно полить, так как прошло более двух дней с даты последнего полива. Дата последнего полива: "  + lastWateringDate + ".";
            } else {
                message = "Кактус не нужно поливать, так как последний полив был менее двух дней назал. Значение датчике влажности: " + humidity + "%. Дата последнего полива: "  + lastWateringDate + ".";
            }
        }

        System.out.println(message);
    }
}
