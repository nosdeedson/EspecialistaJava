package com.br.ejs.ioApiClassica;

import java.io.File;
import java.util.*;

public class PrincipalRenameMyImages {
    public static void main(String[] args) throws InterruptedException {
        renamingFilesRandomNumbersName();
        renamingFilesFromFolderVideos();
    }

    private static void renamingFilesRandomNumbersName(){
        File videos = new File("/home/edson/Vídeos");
        File[] files = videos.listFiles(File::isFile);
        Set<Integer> mix = new HashSet<>(1000);
        Random random = new Random();
        if (files != null){
            for (int i = 0; i < files.length + 100; i++) {
                mix.add(Integer.valueOf(random.nextInt(1000) * random.nextInt(1000)));
            }
            List<Integer> mixList = new ArrayList<>(mix);
            for (int i = 0; i < files.length; i++) {
                File newName = new File("/home/edson/Vídeos/" + mixList.get(i));
                try {
                    System.out.println(files[i].renameTo(newName));
                } catch (RuntimeException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private static void renamingFilesFromFolderVideos() throws InterruptedException {
        System.out.println("##################### RENAMING TO PUT IN IMAGES ###################");
        File videos = new File("/home/edson/Vídeos");
        File[] files = videos.listFiles(File::isFile);
        // always change
        long name = 9801;
        files = videos.listFiles(File::isFile);
        if (files != null){
            for (int i = 0; i < files.length; i++){
                File newName = new File("/home/edson/Vídeos/" +  name);
                try {
                    System.out.println(String.valueOf(files[i].renameTo(newName)) + " = " + name);
                    name++;
                }catch (RuntimeException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
