package com.br.ejs.NewIO.challenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.*;

public class WriteFileToUpperCase {

    public void process() throws IOException {
        Path path = Path.of("src/main/resources/textForChallengeNewIO/textForChallenge.txt");
        Path newFile = Path.of("src/main/resources/textForChallengeNewIO/toUpperCase.txt");

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(newFile, WRITE, CREATE, TRUNCATE_EXISTING)) {
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    bufferedWriter.write(line.toUpperCase() + "\n");
                }
            }
        }
    }


}
