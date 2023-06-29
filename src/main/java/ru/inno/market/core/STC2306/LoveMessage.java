package org.STC2306;

import java.util.Scanner;

public class LoveMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fenceLength, letterLength, spaceLength, messageLength;

        letterLength = 62; // длина трех букв
        spaceLength = 12; // длина одного пробела
        messageLength = letterLength * 5 + spaceLength * 2; // длина сообщения
 
        System.out.print("Введите длину забора: ");
        fenceLength = scanner.nextInt();

        if (fenceLength >= messageLength) {
            System.out.println("На заборе поместится признание в любви!");
        } else {
            System.out.println("На заборе не хватит места для признания в любви.");
        }
    }
}
