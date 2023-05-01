package com.br.ejs.ioApiClassica.challenge;

import java.io.*;

public class ShredderFile {

    private File file;
    private int part;
    public ShredderFile(File file, int part) {
        this.file = file;
        this.part = part;
    }

    public void breakFile() throws IOException {
        int piece = 1;
        File folder = new File("src/main/resources/inputOutputFiles/piecesPhoto");
        folder.mkdir();
        try (InputStream inputStream = new FileInputStream(file)){
            byte[] content = new byte[part];
            int bytes;
            while ( (bytes = inputStream.read(content)) > 0){
                File destination = new File(folder, "piece_"+piece);
                try (OutputStream outputStream = new FileOutputStream(destination)){
                    outputStream.write(content, 0, bytes);
                }catch (IOException e){
                    System.out.println("Creating: " + e.getMessage());
                    throw e;
                }
                piece++;
            }
        } catch (IOException e) {
            throw e;
        }
    }
}
