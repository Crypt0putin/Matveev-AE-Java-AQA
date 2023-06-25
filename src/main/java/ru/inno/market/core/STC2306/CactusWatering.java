package org.STC2306;

import java.time.LocalDate;

public class CactusWatering {
    public static void main(String... args) {
        LocalDate lastWateringDate = LocalDate.of(2021, 9, 1); // ������ ���� ���������� ������
        LocalDate currentDate = LocalDate.now();
        String message;

        if (currentDate.getMonthValue() >= 12 || currentDate.getMonthValue() <= 2) {
            if (currentDate.minusMonths(1).isAfter(lastWateringDate)) {
                message = "������ ����� ������ ��� � ����� �����. ��������� ����� ��� " + lastWateringDate.plusMonths(1);
            } else {
                message = "������ �� ����� �������� �����";
            }
        } else if (currentDate.getMonthValue() <= 5 || currentDate.getMonthValue() >= 9) {
            if (currentDate.minusWeeks(1).isAfter(lastWateringDate)) {
                message = "������ ����� ������ ��� � ������ ������ � ������. ��������� ����� ��� " + lastWateringDate.plusWeeks(1);
            } else {
                message = "������ �� ����� �������� ������ � ������";
            }
        } else {
            int humidity = Sensor.getHumidity();
            if (humidity < 30) {
                message = "������ ����� ������, ��� ��� ��������� ������� ���� 30%";
            } else if (currentDate.minusDays(2).isAfter(lastWateringDate)) {
                message = "������ ����� ������, ��� ��� ������ ����� ���� ���� � ���������� ������";
            } else {
                message = "������ �� ����� �������� �����";
            }
        }

        System.out.println(message);
    }
}