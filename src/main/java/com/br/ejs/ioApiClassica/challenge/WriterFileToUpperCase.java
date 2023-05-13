package com.br.ejs.ioApiClassica.challenge;

import java.io.*;

public class WriterFileToUpperCase {

    private final File toProcess;
    private final File result;

    public WriterFileToUpperCase(File toProcess, File result) {
        this.toProcess = toProcess;
        this.result = result;
    }

    public void process() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(toProcess));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(result))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line.toUpperCase() + "\n");
            }
        }  catch (IOException e) {
            throw e;
        }
    }
}
