package com.br.ejs.NewIO.buffer;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardOpenOption.*;

public class Principal {
    public static void main(String[] args) throws IOException {
        charBuffer();
        byteBuffer();
        decoding();
        readingAText();
        readingATextWithASmallBuffer();
        writtingAText();
        betterWayToReadAFile();
        simplestWaysToRead();
    }

    private static void simplestWaysToRead() throws IOException {
        /*
            all of these ways should be used with small files
            because of the quantity of memory needed
         */
        Path path = Path.of("src/main/resources/toRead/textWrote.txt");
        System.out.println("-------------- first way ---------------");
        try (var stream = Files.lines(path)){
            stream.forEach(System.out::println);
        }
        System.out.println("-------------- second way ---------------");
        Files.readAllLines(path)
                .forEach(System.out::println);
        System.out.println("-------------- thrid way ---------------");
        String content = Files.readString(path);
        System.out.println(content);
        System.out.println("-------------- fourth way ---------------");
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(Arrays.toString(bytes));
    }

    private static void betterWayToReadAFile() throws IOException {
        Path path = Path.of("src/main/resources/toRead/textWrote.txt");
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)){
            bufferedReader.lines()
                    .forEach(System.out::println);
        }
    }

    private static void writtingAText() throws IOException {
        Path path = Path.of("src/main/resources/toRead/textWrote.txt");
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put("E".getBytes());
        buffer.put("d".getBytes());
        buffer.put("s".getBytes());
        buffer.put("o".getBytes());
        buffer.put("n".getBytes());

        try (ByteChannel channel = Files.newByteChannel(path, WRITE, CREATE, TRUNCATE_EXISTING)){
            buffer.flip();
            channel.write(buffer);
        }
    }

    private static void readingATextWithASmallBuffer() throws IOException {
        Path path = Path.of("src/main/resources/toRead/text.txt");
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // using this code this like cora��ão because of the quantity of bytes needed to read 'ç'
        // that will be two or four bytes, and because of the size of the buffer one byte can be
        // in one loop or piece, so when they are separeted the coversion don't know they are parte of
        // the same character.
        try (ByteChannel channel = Files.newByteChannel(path, READ)){
            while (channel.read(buffer) > 0){
                buffer.flip();
                CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer);
                System.out.print(charBuffer);
                buffer.clear();
            }
        }
    }

    private static void readingAText() throws IOException {
        Path path = Path.of("src/main/resources/toRead/text.txt");
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        try (ByteChannel channel = Files.newByteChannel(path, READ)){
            channel.read(buffer);
            buffer.flip();
            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer);
            System.out.println(charBuffer);
        }
    }

    private static void decoding() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(Arrays.toString("Olá".getBytes()));
        buffer.put((byte) 79);
        buffer.put((byte) 108);
        buffer.put((byte) -61);
        buffer.put((byte) -95);
        buffer.flip();
        System.out.println(buffer.limit());
        System.out.println(Arrays.toString(buffer.array()));

        CharBuffer charBuffer = buffer.asCharBuffer();
        System.out.println(charBuffer);
        Charset charset = StandardCharsets.UTF_8;
        CharBuffer charBuffer1 = charset.decode(buffer);
        System.out.println(charBuffer1);
    }

    private static void byteBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(1024); // 1kb

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        buffer.put((byte) 10);
        buffer.put((byte) 23);
        buffer.flip();
        // came back to position zero
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        // content
        System.out.println(Arrays.toString(buffer.array()));
        buffer.clear();
        System.out.println(Arrays.toString(buffer.array()));

        buffer.put((byte) 12);
        buffer.put((byte) 22);
        buffer.put((byte) 32);
        System.out.println(Arrays.toString(buffer.array()));
    }

    private static void charBuffer() {
        CharBuffer charBuffer = CharBuffer.allocate(100);
        charBuffer.put('o');
        charBuffer.put('l');
        charBuffer.put('á');

        // in the line bellow will print just zero because the buffer is on the 3 position of 100 to
        // to print the content we have to use 'flip'
        charBuffer.chars().forEach(System.out::println);
        charBuffer.flip();
        // the buffer points to the first position after the command above
        System.out.println("printiing the content in bytes");
        charBuffer.chars().forEach(System.out::println);
        System.out.println("printiing the char content");
        charBuffer.chars().forEach(c -> System.out.println((char) c));
        System.out.println("printiing the content as string");
        System.out.println(Arrays.toString( charBuffer.array()));

    }

}
