package com.br.ejs.ioApiClassica.challenge;

import java.io.File;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) {
        brokeImage();
//        unifyImage();
        contentFileToUpperCase();
    }

    private static void contentFileToUpperCase() {
        var writer = new WriterFileToUpperCase(
                new File("src/main/resources/inputOutputFiles/texts/lowerCase.txt"),
                new File("src/main/resources/inputOutputFiles/texts/upperCase.txt")
        );
        try {
            writer.process();
        } catch (IOException e) {
            System.out.println("Erro I/O: " + e.getMessage());
        }

    }

    public  static void unifyImage(){
        var unify = new UnifyFile(
                new File("src/main/resources/inputOutputFiles/brokenFiles"),
                new File("src/main/resources/inputOutputFiles/brokenFiles/photo2.jpeg"),
                "photo2.jpg"
        );
        unify.unifyFile();
    }

    public static void brokeImage(){
        try {
            var shredder = new ShredderFile(
                    new File("src/main/resources/inputOutputFiles/photo2.jpeg"),
                    1024 * 50);
            shredder.breakFile();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
