package com.javarush.cryptanalyzer.denisenko;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Encrypt{
    private int key;

    public Encrypt(int key) {
        this.key = key;
    }
    char [] chars = cryptoAlphabet.ALPHABET.toCharArray();

    public static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя0123456789.,\"\":-!? ";

    public String encryptMethod (int key, String pathToFile, String outPath)  {
        try (InputStream inStr = new FileInputStream(pathToFile); OutputStream outStr = new FileOutputStream(outPath)){
            String textOfFile = Files.readString(Path.of(pathToFile));
            String encryptedText = "";
            for (int i = 0; i < textOfFile.length(); i++) {
                int charIndex = ALPHABET.indexOf(textOfFile.charAt(i));
                int newIndex = (charIndex + key)  %ALPHABET.length() ;
                char cipherChar = ALPHABET.charAt(newIndex);
                encryptedText = encryptedText + cipherChar;
                Files.write(Path.of(outPath), encryptedText.getBytes());
            }
            return encryptedText;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public  String decoding(int key, String pathToFile, String outPath){
        try (InputStream inStr = new FileInputStream(pathToFile); OutputStream outStr = new FileOutputStream(outPath)){
            String textOfFile = Files.readAllLines(Path.of(pathToFile)).toString();
            String encryptedText = "";
            for (int i = 0; i < textOfFile.length(); i++) {
                int charIndex = ALPHABET.indexOf(textOfFile.charAt(i));
                int newIndex = (charIndex - key) ;
                if(newIndex<0){
                    newIndex = ALPHABET.length()+newIndex;
                }
                char cipherChar = ALPHABET.charAt(newIndex);
                encryptedText = encryptedText + cipherChar;
            }
            outStr.write(encryptedText.getBytes());
            return encryptedText;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

   /* public void encrypt(InputStream inStr, OutputStream outStr) throws IOException {
        boolean done = false;
        while (!done){
            int next =inStr.read();
            if(next == -1 ) {
                done = true;
            }else {
                byte b =(byte) next;
                byte c = (byte) (b +key);
                outStr.write(c);
            }
        }
    }*/

}
