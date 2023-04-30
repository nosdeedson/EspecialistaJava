package com.br.ejs.ioApiClassica.creatingFiles;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Pricipal {

    public static void main(String[] args) throws IOException, InterruptedException {
        testingClassFile();
        testingPathFiles();
        renamingFolder();
        getNameFile();
        isFolderOrFile();
        existFileOrFolder();
        fileIsHidden();
        fileWasModified();
        fileSize();
        fileIsExecutable();
        canReadFile();
        canWriteFile();
        deletingFolder();
        listingFiles();
//        renamingFilesFromFolderVideos();
    }

    private static void renamingFilesFromFolderVideos() {
        File videos = new File("/home/edson/Vídeos");
        File[] files = videos.listFiles(File::isFile);
//        Set<Integer> mix = new HashSet<>(1000);
//        Random random = new Random();

        long name = 9548;
        if (files != null){
//            for (int i = 0; i < files.length + 100; i++) {
//                mix.add(Integer.valueOf(random.nextInt(1000) * random.nextInt(1000)));
//            }
//            List<Integer> mixList = new ArrayList<>(mix);
//            System.out.println(mixList);
            for (int i = 0; i < files.length; i++) {
                File newName = new File("/home/edson/Vídeos/" +  name);
                try {
//                    System.out.println(files[i].getName());
                    System.out.println(files[i].renameTo(newName));
                    name++;
                } catch (RuntimeException e){
                    e.printStackTrace();
                }
            }
//            System.out.println(mix);
        }
    }

    private static void listingFiles() throws IOException {
        System.out.println("################## LISNTING FILES #####################");
        File folder = new File("src/main/resources/documents");
        System.out.printf("folder 1 created? %b%n", folder.mkdir());
        File folder2 = new File(folder, "folderInsideFolder");
        System.out.printf("folder 2 created? %b%n", folder2.mkdir());
        File file = new File(folder, "file1.txt");
        System.out.printf("file created? %b%n", file.createNewFile());
        File file1 = new File(folder, "file2.txt");
        System.out.printf("file created? %b%n", file1.createNewFile());
        File file2 = new File(folder, "file3.png");
        System.out.printf("file created? %b%n", file2.createNewFile());
        File file3 = new File(folder, "test.png");
        System.out.printf("file created? %b%n", file3.createNewFile());
        File file4 = new File(folder, "tdirectory");
        System.out.printf("folder 4 created? %b%n", file4.mkdir());
        System.out.println("----------------- listing files and folders -------------------------");
        File[] files = folder.listFiles();
        if (files != null){
            for (File f : files) {
                System.out.println(f.getName());
            }
        }
        System.out.println("---------------- listing folders ---------------------");
        File[] directories = folder.listFiles(File::isDirectory);
        if (directories != null){
            for (File directory : directories) {
                System.out.printf("%s is a directory? %s%n",directory.getName(), directory.isDirectory() ? "yes" : "no");
            }
        }
        System.out.println("------------------------- listing files -------------------");
        File[] files1 = folder.listFiles(File::isFile);
        if ((files1 != null)){
            for (File f : files1) {
                System.out.printf("%s is a file? %s%n",f.getName(), f.isFile() ? "yes": "no");
            }
        }
        System.out.println("--------------------- filtering by name ---------------------");
        File[] selectingFiles = folder.listFiles((dir, name) -> name.startsWith("t"));
        if (selectingFiles != null){
            for (File selectingFile : selectingFiles) {
                System.out.println(selectingFile.getName());
            }
        }

    }

    private static void canWriteFile() {
        System.out.println("################## FILE OR FOLDER WAS MODIFIED #####################");
        File documents = new File("src/main/resources/documents");
        File file = new File(documents, "teste.txt");
        System.out.printf("can write: %s%n", documents.canWrite() ? "yes" : "no");
        System.out.printf("can write: %s%n", file.canWrite() ? "yes" : "no");
    }

    private static void canReadFile() {
        System.out.println("################## FILE OR FOLDER CAN READ #####################");
        File documents = new File("src/main/resources/documents");
        File file = new File(documents, "teste.txt");
        System.out.printf("can read: %s%n", documents.canRead() ? "yes" : "no");
        System.out.printf("can read: %s%n", file.canRead() ? "yes" : "no");
    }

    private static void fileIsExecutable() {
        System.out.println("################## FILE OR FOLDER IS EXECUTABLE #####################");
        File documents = new File("src/main/resources/documents");
        File file = new File(documents, "teste.txt");
        System.out.println(documents.canExecute() ? "executable" : "not executable");
        System.out.println(file.canExecute() ? "executable" : "not executable");
    }

    private static void fileSize() {
        System.out.println("################## FILE OR FOLDER SIZE #####################");
        File documents = new File("src/main/resources/documents");
        File file = new File(documents, "teste.txt");
        System.out.println("size: " + documents.length());
        System.out.println("size: " + file.length());
    }

    private static void fileWasModified() throws InterruptedException {
        System.out.println("################## FILE OR FOLDER WAS MODIFIED #####################");
        File documents = new File("src/main/resources/documents");
        File file = new File(documents, "teste.txt");
        long documentsWasModified = documents.lastModified();
        long fileWasModified = file.lastModified();
        if (documentsWasModified < Instant.now().toEpochMilli()){
            System.out.println("documents was modified? yes");
        } else {
            System.out.println("documents was modified? no");
        }

        if (fileWasModified < Instant.now().toEpochMilli()){
            System.out.println("documents was modified? yes");
        } else {
            System.out.println("documents was modified? no");
        }

        System.out.println("---------------- using date -------------------");
        LocalDateTime docModified = LocalDateTime.ofInstant(Instant.ofEpochMilli(documentsWasModified), ZoneId.of("America/Sao_Paulo"));
        LocalDateTime fileModified = LocalDateTime.ofInstant(Instant.ofEpochMilli(fileWasModified), ZoneId.of("America/Sao_Paulo"));
        if (docModified.isBefore(LocalDateTime.now())){
            System.out.println("documents was modified? yes");
        }else {
            System.out.println("documents was modified? no");
        }

        if (fileModified.isBefore(LocalDateTime.now())){
            System.out.println("documents was modified? yes");
        }else {
            System.out.println("documents was modified? no");
        }
    }

    private static void fileIsHidden() {
        System.out.println("################## IS HIDDEN FILE OR FOLDER #####################");

        File documents = new File("src/main/resources/documents");
        File file = new File(documents, "teste.txt");
        System.out.printf("Is hidden? %s%n", documents.isHidden()? "yes": "no");
        System.out.printf("Is hidden? %s%n", file.isHidden()? "yes": "no");
    }

    private static void existFileOrFolder() {
        System.out.println("################## EXIST FILE OR FOLDER #####################");
        /*
        Below we have a relative path
         */
        File documents = new File("src/main/resources/documents");
        File file = new File(documents, "teste.txt");
        System.out.printf("Exists? %s%n" , documents.exists() ? "yes": "no");
        System.out.printf("Exists? %s%n" , file.exists() ? "yes": "no");

        System.out.println("--------------- files don't exist ---------------------");
        File doc = new File("src/main/resources/doc");
        File file1 = new File(doc, "teste.txt");
        System.out.printf("Exists? %s%n" , doc.exists() ? "yes": "no");
        System.out.printf("Exists? %s%n" , file1.exists() ? "yes": "no");

    }

    private static void isFolderOrFile() {
        System.out.println("################## IS FOLDER OR FILE #############################");
        File documents = new File("src/main/resources/documents");
        File file = new File(documents, "teste.txt");
        System.out.printf("Is file? %s%n", file.isFile() ? "yes": "no");
        System.out.printf("Is folder? %s%n", file.isDirectory()? "yes": "no");

        System.out.printf("Is file? %s%n", documents.isFile() ? "yes": "no");
        System.out.printf("Is folder? %s%n", documents.isDirectory()? "yes": "no");
    }

    public static void getNameFile(){
        System.out.println("####################### GETING NAME FILES #########################");
        File documents = new File("src/main/resources/documents");
        File file = new File(documents, "teste.txt");
        System.out.printf("Name: %s%n", file.getName());
        System.out.println("----------------- parent folder -------------------------");
        System.out.printf("Parent folder: %s%n", documents.getName());
    }

    public static void deletingFolder(){
        /**
         * to delete a folder it must be empty
         */
        System.out.println("#################### DELETING ###############################");
        File documents = new File("/home/edson/git/EspecialistaJava/src/main/resources/documents");
        File file1 = new File(documents, "teste.txt");
        File file2 = new File(documents, "teste2.txt");
        System.out.printf("File1 deleted: %b%n", file1.delete());
        System.out.printf("File2 deleted: %b%n", file2.delete());
        System.out.printf("Documents deleted: %b%n", documents.delete());
    }

    public static  void renamingFolder(){
        File folder1 = new File("/home/edson/git/EspecialistaJava/src/main/resources/folder1");
        File folder2 = new File("/home/edson/git/EspecialistaJava/src/main/resources/documents");
        System.out.println("######################### RENAMING #######################");
        System.out.printf("old name: %s%n ", folder1.getName());
        System.out.printf("renamed? %s%n", folder1.renameTo(folder2) ? "yes": "no");
        System.out.println("new name: " + folder1.getName());
    }

    public static void testingPathFiles() throws IOException {
        System.out.println("#######################TESTING PATH FILES #############################");
        File file1 = new File("/home/edson/git/EspecialistaJava/src/main/resources/folder1/test3.txt");
        System.out.println(file1);
        System.out.println();

        File file2 = new File("/home/edson/git/EspecialistaJava/src/main/resources/folder1/test4.txt");
        System.out.println(file2);
        System.out.println(file2.getAbsoluteFile());
        System.out.println();

        File file3 = new File("../docs/test5.txt");
        System.out.println(file3);
        System.out.println(file3.getAbsoluteFile());
        System.out.println(file3.getCanonicalFile());
    }

    public static void testingClassFile() throws IOException {
        /**
         * Cria uma pasta de acordo com o caminhho
         * Criará a última pasta apenas
         */
        File folder1 = new File("/home/edson/git/EspecialistaJava/src/main/resources/folder1");
        System.out.printf("Folder created: %b%n", folder1.mkdir());

        /**
         * Cria todas as pastas não criadas
         */
        File folder2 = new File("/home/edson/git/EspecialistaJava/src/main/resources/folder2/photos");
        System.out.printf("Folder created: %b%n", folder2.mkdirs());

        /**
         * Creating real files
         */
        File file1 = new File("/home/edson/git/EspecialistaJava/src/main/resources/folder1/teste.txt");
        File file2 = new File("/home/edson/git/EspecialistaJava/src/main/resources/folder2/photos/teste.png");
        File file3 = new File(folder1, "teste2.txt");
        System.out.printf("File1 created: %b%n", file1.createNewFile() );
        System.out.printf("File2 created: %b%n", file2.createNewFile() );
        System.out.printf("File3 created: %b%n", file3.createNewFile() );
    }
}
