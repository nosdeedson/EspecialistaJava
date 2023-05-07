package com.br.ejs.NewIO.functionalities;


import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardCopyOption.*;

public class Principal {

    public static void main(String[] args) throws IOException {
        instaciatingPathUsingFileSystem();
        instaciatingPath();
        absoluteAndRelative();
        resolvingPath();
        creatingdirectories();
        creatingDirectory();
        creatingFiles();
        copyingFiles();
        copyingAndReplaceIfExists();
        movingFile();
        movingFolder();
        usingfind();
        deletingFilesAndFolders();
        deletingRecursively();
    }

    private static void usingfind() throws IOException {
        System.out.println("############################## USING FINF OF FILES ###############################");
        Path path = Path.of("src/main/resources/NewIOFiles");
        /*
        find requires a path, how many folders to enter in the case bellow was passed 'Integer.MAX'
        (the bigest int suported by the class Integer) and the third atribute is an funcional interface
        which is BiPredicate that receives two paramenter and return a boolean
        bellow was passed the path and the File represented by the path
         */
        try(var stream =  Files.find(path, Integer.MAX_VALUE,
                (path1, attrs) -> path1.getFileName().toString().matches(".*\\.txt") )){
            stream.forEach(System.out::println);
        }
    }

    private static void deletingRecursively() throws IOException {
        System.out.println("################# DELETING RECURSIVELY ######################");
        Path tree = Path.of("src/main/resources/NewIOFiles/tree");
        firstWay(tree);
        secondWay(tree);
        firstCreatingTreeOfFoldersAndFiles();
        myWay(tree);
    }

    private static void myWay(Path path) throws IOException {
        System.out.println("###################### MY WAY ##########################");

        List<Path> paths = Files.list(path).collect(Collectors.toList());
        for (Path fileORDiretory : paths) {
            if (Files.isRegularFile(fileORDiretory)){
                System.out.println("file: " + fileORDiretory);
                Files.delete(fileORDiretory);
            } else if (Files.isDirectory(fileORDiretory)) {
                myWay(fileORDiretory);
            }
        }
        if (Files.list(path).collect(Collectors.toList()).size() == 0){
            System.out.println("folder: " + path);
            Files.delete(path);
        }
    }

    private static void secondWay(Path path) throws IOException{
        System.out.println("-------------------- SECOND WAY -------------------------");
        firstCreatingTreeOfFoldersAndFiles();
        Files.walkFileTree(path, new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("Deleting: " + file);
                Files.deleteIfExists(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("Deleting: " + dir);
                Files.deleteIfExists(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void firstWay(Path path) throws IOException {
        System.out.println("------------------------- FIRST WAY ------------------------------");
        firstCreatingTreeOfFoldersAndFiles();

        // first way anonumous class for the interface 'FileVisitor
        Files.walkFileTree(path, new FileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                System.out.println("Deleting: " + path);
                Files.deleteIfExists(path);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path path, IOException e) {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException {
                System.out.println("Deleting: " + path);
                Files.deleteIfExists(path);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void firstCreatingTreeOfFoldersAndFiles() throws IOException {
        Path firstFolder = Path.of("src/main/resources/NewIOFiles/tree/branch1");
        Files.createDirectories(firstFolder);
        Path secondFolder = Path.of("src/main/resources/NewIOFiles/tree/branch2");
        Files.createDirectory(secondFolder);

        Path treeFile = Path.of("src/main/resources/NewIOFiles/tree/treefile1.txt");
        Path treeFile1 = Path.of("src/main/resources/NewIOFiles/tree/treefile2.txt");
        Path treeFile2 = Path.of("src/main/resources/NewIOFiles/tree/treefile3.txt");
        Files.createFile(treeFile);
        Files.createFile(treeFile1);
        Files.createFile(treeFile2);

        Path branch1File = Path.of("src/main/resources/NewIOFiles/tree/branch1/branchfile1.txt");
        Path branch1File1 = Path.of("src/main/resources/NewIOFiles/tree/branch1/branchfile2.txt");
        Path branc1File2 = Path.of("src/main/resources/NewIOFiles/tree/branch1/branchfile3.txt");
        Files.createFile(branch1File);
        Files.createFile(branch1File1);
        Files.createFile(branc1File2);

        Path branch2File = Path.of("src/main/resources/NewIOFiles/tree/branch2/branchfile1.txt");
        Path branch2File1 = Path.of("src/main/resources/NewIOFiles/tree/branch2/branchfile2.txt");
        Path branc2File2 = Path.of("src/main/resources/NewIOFiles/tree/branch2/branchfile3.txt");
        Files.createFile(branch2File);
        Files.createFile(branch2File1);
        Files.createFile(branc2File2);
    }

    private static void deletingFilesAndFolders() throws  IOException {
        /*
          the function 'delete' just erase empty folders
         */
        System.out.println("######################## DELETING #########################");
        Path file = Path.of("src/main/resources/NewIOFiles/documents/newFolder/doc1.txt");
        Files.deleteIfExists(file);
        System.out.println("---------------------- FOLDER ----------------------------");
        Path folder = Path.of("src/main/resources/NewIOFiles/documents/newFolder");
        Files.deleteIfExists(folder);
    }
    private static void movingFolder() throws IOException {
        /*
         * actually the function rename de folder moved to newFolder, but the file in the foler
         * 'moved' will be moded to the folder 'newFolder'
         */
        System.out.println("######################## MOVING FOLDER ########################");
        Path toMove = Path.of("src/main/resources/NewIOFiles/documents/moved");
        Path newFolder = Path.of("src/main/resources/NewIOFiles/documents/newFolder");
        if (!Files.exists(newFolder)){
            Files.move(toMove, newFolder);
        }
    }
    private static void movingFile() throws IOException {
        System.out.println("######################## MOVING FILES ########################");

        File file = new File("src/main/resources/NewIOFiles/documents/moved");
        // creates the moved folder
        System.out.println(file.mkdir());

        Path folderFiles = Path.of("src/main/resources/NewIOFiles/documents/files");
        Path fileDoc1 = Path.of("doc1.txt");
        Path fileOrigin = folderFiles.resolve(fileDoc1);

        Path folderDestination = Path.of("src/main/resources/NewIOFiles/documents/moved");
        Path fileDestination = folderDestination.resolve(fileDoc1);
        System.out.println("Origin: " + fileOrigin);
        System.out.println("Destination: " + fileDestination);
        // in this cas de folder moved want be created
        if (!Files.exists(fileDestination)){
            Files.move(fileOrigin, fileDestination);
        }
    }
    private static void copyingAndReplaceIfExists() throws IOException {
        System.out.println("################## COPYING AND REPLACING IF EXISTS");
        Path folderFiles = Path.of("src/main/resources/NewIOFiles/documents/files");
        Path fileDoc1 = Path.of("doc1.txt");
        Path fileOrigin = folderFiles.resolve(fileDoc1);

        Path documents = Path.of("src/main/resources/NewIOFiles/documents");
        Path destinationFile = documents.resolve(fileDoc1);
        System.out.println("Origin: " + fileOrigin);
        System.out.println("Destination: " + destinationFile);
//        Files.copy(fileOrigin, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(fileOrigin, destinationFile, REPLACE_EXISTING); // static import
    }
    private static void copyingFiles() throws IOException {
        System.out.println("#################### COPYING FILES ##########################");
        Path files = Path.of("src/main/resources/NewIOFiles/documents/files");
        Path file = Path.of("doc1.txt");
        Path fileOrigin = files.resolve(file);

        Path documents = Path.of("src/main/resources/NewIOFiles/documents");
        Path destinationFile = documents.resolve(file);
        System.out.println("ORIGIN: " + fileOrigin);
        System.out.println("DESTINATION: " +destinationFile);
        if (!Files.exists(destinationFile)){
            Files.copy(fileOrigin, destinationFile);
        }
    }
    private static void creatingFiles() throws  IOException {
        System.out.println("#################### CREATING FILES ##########################");
        Path path = Path.of("src/main/resources/NewIOFiles/documents/doc.txt");
        if (!Files.exists(path)){
            Files.createFile(path);
        }
        Path path1 = Path.of("src/main/resources/NewIOFiles/documents/files/doc1.txt");
        if (!Files.exists(path1)){
            Files.createFile(path1);
        }

        System.out.println(Files.exists(path));
        System.out.println(Files.exists(path1));

    }
    private static void creatingdirectories() throws IOException {
        System.out.println("################## CREATING DIRECTORIES ############################");
        Path path = Path.of("src/main/resources/NewIOFiles/documents/files");
        if (!Files.exists(path)){
            Files.createDirectories(path);
        }
        System.out.println(Files.exists(path));
    }

    private static void creatingDirectory() throws IOException {
        System.out.println("################## CREATING DIRECTORY ############################");
        Path path = Path.of("src/main/resources/NewIOFiles/documents");
        if (!Files.exists(path)){
            Files.createDirectory(path);
        }
        System.out.println(Files.exists(path));
    }

    public static void resolvingPath(){
        System.out.println("####################### RESOLVING PATH ############################");
        Path path = Path.of("src/main/resources/NewIOFiles");
        Path path1 = Path.of("src/main/resources/NewIOFiles/docs.txt");
        Path path2 = path.resolve(path1);

        System.out.println(path2);
        System.out.println(path2.toAbsolutePath());
    }

    private static void absoluteAndRelative() {
        System.out.println("####################### ABSOLUTE RELATIVE PATH ###########################");
        Path file = Path.of("src/main/resources/NewIOFiles/docs.txt");
        Path file1 = Path.of("docs.txt");
        System.out.println("Relative path: " + file);
        System.out.println("Relative path: " + file1);
        System.out.println("----------------- ABSOLUTE PATH ------------------------");
        Path file2 = file.toAbsolutePath();
        Path file3 = file1.toAbsolutePath();
        System.out.println("Absoulte path: " + file2);
        System.out.println("Absoulte path: " + file3);

        System.out.println("------------------ CHECKING PATH");
        System.out.println("is relative: " + !file.isAbsolute());
        System.out.println("is relative: " + !file2.isAbsolute());
        System.out.println("is absolute: " + file.isAbsolute());
        System.out.println("is absolute: " + file2.isAbsolute());

    }

    private static void instaciatingPath() {
        System.out.println("############################# JUST PATH ##########################");
        Path path = Path.of("/home/edson/git/EspecialistaJava/src/main/resources/NewIOFiles/docs.txt");
        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println("---------------- File to Path and Path to File ----------------------");
        File file = path.toFile();
        Path path1 = file.toPath();
        System.out.println(file.getName());
        System.out.println(path1.getFileName());
    }

    private static void instaciatingPathUsingFileSystem() {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("/home/edson/git/EspecialistaJava/src/main/resources/NewIOFiles/docs.txt");
        System.out.println(path.getFileName());
        System.out.println(path.getParent());
    }
}
