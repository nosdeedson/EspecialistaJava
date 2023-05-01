package com.br.ejs.ioApiClassica.challenge;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class UnifyFile {

    private File photo;
    private File folder;

    public UnifyFile(File folder, File photo) {
        this.folder = folder;
        this.photo = photo;
    }

    public void unifyFile() throws IOException {
        List<File> files = sortFiles();
        System.out.println(files);
        creatingPhotoUnified(files);
    }

    private void creatingPhotoUnified(List<File> files){
        try (OutputStream outputStream = new FileOutputStream(photo)){
            for (File file : files) {
                writeFragment(file, outputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeFragment(File file, OutputStream outputStream) {
        try (InputStream inputStream = new FileInputStream(file)){
            byte[] content = new byte[1024];
            int amountBytes;
            while ((amountBytes = inputStream.read(content)) > 0){
                outputStream.write(content, 0, amountBytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<File> sortFiles() {
        boolean temFile = true;
        int piece = 1;
        List<File> listSorted = new ArrayList<>();
        while (temFile){
            int finalPiece = piece;
            File[] files = folder.listFiles((dir, name) -> name.endsWith("piece_"+ finalPiece));
            if (files.length > 0){
                listSorted.add(files[0]);
                piece++;
            }else {
                temFile = false;
            }
        }
        return listSorted;
    }
}
