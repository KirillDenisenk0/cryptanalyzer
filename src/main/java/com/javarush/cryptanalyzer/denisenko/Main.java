package com.javarush.cryptanalyzer.denisenko;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        while (input != 6) {
            System.out.println("Выберите действие: ");
            System.out.println("1. Зашифровать, используя предоставленный файл.");
            System.out.println("2. Зашифровать, используя свой файл.");
            System.out.println("3. Расшифровать.");
            System.out.println("4. Расшифровать(грубая сила).");
            System.out.println("5. Выход.");
            input = scanner.nextInt();
            if (input == 1) {
                String outPath = "C:\\Users\\Bulbazaur1\\IdeaProjects\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\denisenko\\outFile";
                String inPath = "C:\\Users\\Bulbazaur1\\IdeaProjects\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\denisenko\\baseFile.txt";
                System.out.println("Введите ключ шифрования: ");
                int key = scanner.nextInt();
                Encrypt encrypt = new Encrypt(key);
                System.out.println("Процесс шифрования....");
                encrypt.encryptMethod(key, inPath, outPath);
                System.out.println("Шифрование прошло успешно!");

            } else if (input == 2) {
                try {
                    System.out.println("Введите путь до файла: ");
                    String linePath = scanner.next();
                    Path path = Path.of(linePath);
                    if (Files.exists(path)) {
                        String outPath = "C:\\Users\\Bulbazaur1\\IdeaProjects\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\denisenko\\outFile";
                        String inPath = linePath;
                        System.out.println("Введите ключ шифрования: ");
                        int key = scanner.nextInt();
                        Encrypt encrypt = new Encrypt(key);
                        System.out.println("Процесс шифрования....");
                        encrypt.encryptMethod(key, inPath, outPath);
                        System.out.println("Шифрование прошло успешно!");
                    } else if (!(Files.exists(path))) {
                        Files.createFile(path);
                        System.out.println("Проверка пути..");
                        System.out.println("Файл создан и готов к работе!");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (input == 3) {
                String outPath = "C:\\Users\\Bulbazaur1\\IdeaProjects\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\denisenko\\outFile";
                String inPath = "C:\\Users\\Bulbazaur1\\IdeaProjects\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\denisenko\\baseFile.txt";
                System.out.println("Введите ключ шифрования: ");
                int key = scanner.nextInt();
                Encrypt decoding = new Encrypt(key);
                decoding.decoding(key, outPath, inPath);
            } else if (input == 0) {
                char[] chars = cryptoAlphabet.ALPHABET.toCharArray();
                System.out.println(chars.length);
            } else if (input == 4) {





            } else if (input == 5) {
                break;
            }
        }

    }
}