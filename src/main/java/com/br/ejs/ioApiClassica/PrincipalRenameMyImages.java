package com.br.ejs.ioApiClassica;

import java.io.File;

public class PrincipalRenameMyImages {
    public static void main(String[] args) {
        renamingFilesFromFolderVideos();
    }

    private static void renamingFilesFromFolderVideos() {
        File videos = new File("/home/edson/Vídeos");
        File[] files = videos.listFiles(File::isFile);
//        Set<Integer> mix = new HashSet<>(1000);
//        Random random = new Random();

        long name = 9548;
        if (files != null){
//            for (int i = 0; i < files.length + 100; i++) {
//                mix.add(Integer.valueOf(random.nextInt(1000) * random.nextInt(1000)));
//            }
//            List<Integer> mixList = new ArrayList<>(mix);
//            System.out.println(mixList);
            for (int i = 0; i < files.length; i++) {
                File newName = new File("/home/edson/Vídeos/" +  name);
                try {
//                    System.out.println(files[i].getName());
                    System.out.println(files[i].renameTo(newName));
                    name++;
                } catch (RuntimeException e){
                    e.printStackTrace();
                }
            }
//            System.out.println(mix);
        }
    }
}
