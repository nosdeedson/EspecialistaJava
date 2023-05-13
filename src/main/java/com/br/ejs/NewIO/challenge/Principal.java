package com.br.ejs.NewIO.challenge;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {
//        WriteFileToUpperCase write = new WriteFileToUpperCase();
//        write.process();
//        ShredderFile shredderFile = new ShredderFile();
//        shredderFile.breakFile(1024 * 50);
        UnifyFile file = new UnifyFile();
        file.unifyFile();
    }
}
