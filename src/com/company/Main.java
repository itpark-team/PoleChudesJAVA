package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final char CONST_HIDDEN_LETTER = '*';

        char[] originalWord;
        String question;

        char[] guessWord;

        boolean isGuessed;

        System.out.print("Введите загадку: ");
        question = scanner.nextLine();

        System.out.print("Введите загаданное слово: ");
        originalWord = scanner.nextLine().toCharArray();

        guessWord = new char[originalWord.length];
        for (int i = 0; i < guessWord.length; i++) {
            guessWord[i] = CONST_HIDDEN_LETTER;
        }

        do {
            //clear screen
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }

            System.out.println(question);
            System.out.println("Отгаданное слово");
            for (int i = 0; i < guessWord.length; i++) {
                System.out.print(guessWord[i] + " ");
            }
            System.out.println();

            System.out.print("Введите предполагаемую букву или слово целиком: ");
            String inputLine = scanner.nextLine();

            if (inputLine.length() == 1) {

                char inputLetter = inputLine.charAt(0);

                boolean isFound = false;
                for (int i = 0; i < originalWord.length; i++) {
                    if (originalWord[i] == inputLetter) {
                        guessWord[i] = inputLetter;
                        isFound = true;
                    }
                }

                if (isFound == true) {
                    System.out.println("Поздравляем, такая буква есть в слове!");
                } else {
                    System.out.println("К сожалению такой буквы нет");
                }
                System.out.println("Для продолжения нажмите <Enter>");
                scanner.nextLine();

                isGuessed = true;
                for (int i = 0; i < guessWord.length; i++) {
                    if (guessWord[i] == CONST_HIDDEN_LETTER) {
                        isGuessed = false;
                        break;
                    }
                }
            } else {
                isGuessed = true;

                char[] inputWord = inputLine.toCharArray();

                if (originalWord.length != inputWord.length) {
                    isGuessed = false;
                } else {
                    for (int i = 0; i < originalWord.length; i++) {
                        if (originalWord[i] != inputWord[i]) {
                            isGuessed = false;
                        }
                    }
                }

                if (isGuessed == true) {
                    for (int i = 0; i < inputWord.length; i++) {
                        guessWord[i] = inputWord[i];
                    }
                }
            }

        }
        while (isGuessed == false);

        //clear screen
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        System.out.println("Подздравляем вы отгадали. Загаданное слово:");
        for (int i = 0; i < guessWord.length; i++) {
            System.out.print(guessWord[i]);
        }
    }
}
