package com.br.ejs.ioApiClassica.inputOutputStream;

import java.io.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        readingFile();
        bestPratice();
        readingPhoto();
        readingTextFile("text2.txt");
        writingTextInFile();
        lineReader();
        bufferWriter();
        justAExample();
    }

    private static void justAExample() throws IOException {
        System.out.println("################# TYPE SOMETHING OR LEAVE  ###############");
        InputStream inputStream = System.in;
        Scanner scanner = new Scanner(inputStream);
        String line = null;
        while (!(line = scanner.nextLine()).equals("LEAVE")){
            System.out.println("you typed: " + line);
        }
        System.out.println("################# TYPE SOMETHING OR LEAVE  ###############");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (!(line = reader.readLine()).equals("LEAVE")){
            System.out.println("you typed: " + line);
        }

        System.out.println("-------------- READING A FILE ---------");
        scanner = new Scanner(new FileInputStream("src/main/resources/inputOutputFiles/test.txt"));
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }

    private static void bufferWriter() {
        System.out.println("################# WRITING WITH BUFFERWRITER ##############################3");
        File file = new File("src/main/resources/inputOutputFiles/text3.txt");
        File file1 = new File("src/main/resources/inputOutputFiles/text4.txt");
        try (Reader reader = new FileReader(file);
            Writer writer = new BufferedWriter(new FileWriter(file1))){
            int text;
            while ((text = reader.read()) > 0){
                writer.write(text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("################# FINISHED WRITING WITH BUFFERWRITER ####################3333");
    }

    private static void lineReader() {
        System.out.println("################### READING LINE BY LINE #########################################");
        File file = new File("src/main/resources/inputOutputFiles/text3.txt");
        String linha;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while ((linha = bufferedReader.readLine()) != null){
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void writingTextInFile() {
        System.out.println("########################### WRITING A FILE #####################");
        String text[] = { "Lorem ", "Ipsum ", "is ", "simply ", "dummy ", "text ", "of ", "the ", "printing ", "and ",
        "typesetting ", "industry. ", "Lorem ", "Ipsum ", "has ", "been ", "the ", "industry's ", "standard ", "dummy ", "text ",
        "ever ", "since ", "the ", "1500s, ", "when ", "an ", "unknown ", "printer ", "took ", "a ", "galley ", "of ", "type ", "and ",
        "scrambled ", "it ", "to ", "make ", "a ", "type ", "specimen ", "book. ", "It", "has ", "survived ", "not ", "only ", "five ",
        "centuries, ", "but ", "also ", "the ", "leap ", "into ", "electronic ", "typesetting, ", "remaining ", "essentially ",
        "unchanged. ", "It ", "was ", "popularised ", "in ", "the ", "1960s ", "with ", "the ", "release", "of ", "Letraset ",
        "sheets ", "containing ", "Lorem ", "Ipsum ", "passages, ", "and ", "more ", "recently ", "with ", "desktop ", "publishing ",
        "software ", "like ", "Aldus ", "PageMaker ", "including ", "versions ", "of ", "Lorem ", "Ipsum."};
        
        File file = new File("src/main/resources/inputOutputFiles/text3.txt");
        try (Writer writer = new FileWriter(file)){
            for (String s : text) {
                writer.write(s);
                if (s.contains(".")){
                    writer.write("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------------------- reading after writing ---------------------");
        readingTextFile("text3.txt");
    }

    private static void readingTextFile(String nameFile) {
        System.out.println();
        System.out.println("################## READING TEXT FILE #####################");
        File file = new File("src/main/resources/inputOutputFiles/" + nameFile);

        StringBuilder texto = new StringBuilder();
        try (Reader reader = new FileReader(file)){
            char[] content = new char[1000];
            int amountCharacter;
            while ((amountCharacter = reader.read(content)) > 0){
                texto.append(content, 0, amountCharacter);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println(texto.toString());
    }

    private static void readingPhoto() {
        File origin = new File("src/main/resources/inputOutputFiles/photo.jpg");
        File destination = new File("src/main/resources/inputOutputFiles/photo2.jpg");

        // using the try in the wat bellow we don't have to close the InputStream or the OutputStream
        try (InputStream inputStream = new FileInputStream(origin);
        OutputStream outputStream = new FileOutputStream(destination)){
            byte[] content = new byte[1024]; // this allow to read 1024 bytes of the file without this the file will be read byte by byte
            int amountOfBytes;
            while ((amountOfBytes = inputStream.read(content)) > 0){
                outputStream.write(amountOfBytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void bestPratice() throws FileNotFoundException {
        System.out.println("#################### BETTER WAY #############################");

        File file = new File("src/main/resources/inputOutputFiles/test.txt");
        InputStream input = new FileInputStream(new File("src/main/resources/inputOutputFiles/test.txt"));

        try (InputStream inputStream = new FileInputStream(file);
            input){
            int content;
            while ((content = inputStream.read()) != -1){
                System.out.print((char) content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readingFile()  {
        System.out.println("#################### FIRST WAY #############################");
        File file = new File("src/main/resources/inputOutputFiles/test.txt");
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(file);
            int content;
            while ((content = inputStream.read()) != -1){
                System.out.print((char) content);
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
