package com.br.ejs.NewIO.challenge;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.*;

public class ShredderFile {

    public void breakFile(int size) throws IOException {
        int piece = 1;
        Path image = Path.of("src/main/resources/imageForChallengeNewIO/image.jpeg");
        int bytes;
        byte[] content = new byte[size];
        try (InputStream inputStream = Files.newInputStream(image, READ)){
            while ((bytes = inputStream.read(content)) > 0){
                Path part = Path.of("src/main/resources/imageForChallengeNewIO/parts/part_"+piece);
                try (OutputStream outputStream = Files.newOutputStream(part, CREATE, WRITE)){
                    outputStream.write(content, 0, bytes);
                }
                piece++;
            }
        }
    }

}
