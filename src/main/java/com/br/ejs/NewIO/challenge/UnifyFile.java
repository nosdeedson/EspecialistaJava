package com.br.ejs.NewIO.challenge;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UnifyFile {

    public void unifyFile() throws IOException {
        List<Path> paths = sortFiles();
        Path unified = Path.of("src/main/resources/imageForChallengeNewIO/parts/partsTogether.jpeg");
        creatingPictureUnified(paths, unified);
    }

    private void creatingPictureUnified(List<Path> paths, Path unified) throws IOException {
        try (OutputStream outputStream = Files.newOutputStream(unified)){
            for (Path p: paths){
                writePart(p, outputStream);
            }
        }
    }

    private void writePart(Path path, OutputStream out) throws IOException {
        try (InputStream inputStream = Files.newInputStream(path)){
            byte[] content = new byte[1024 * 50];
            int amountBytes;
            while ((amountBytes = inputStream.read(content)) > 0){
                out.write(content, 0, amountBytes);
            }
        }
    }

    private List<Path> sortFiles() throws IOException {
        List<Path> pathList = new ArrayList<>();
        Path parts = Path.of("src/main/resources/imageForChallengeNewIO/parts");
        int part = 1;
        while (Files.list(parts).count() > part){
            int finalPart = part;
            Stream<Path> piece = Files.find(parts, 1, (p, attrs) -> p.getFileName().toString().endsWith(String.valueOf("part_"+finalPart)));
            pathList.add(piece.findFirst().get());
            part++;
        }
        return pathList;
    }
}
