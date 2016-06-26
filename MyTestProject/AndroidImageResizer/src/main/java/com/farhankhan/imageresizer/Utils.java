package com.farhankhan.imageresizer;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by farhankhan on 6/26/16.
 */
public class Utils {

    public static void resizeImageTo(String pSourceIcon, String pPath, String pIconName, int pWidth, int pHeight) throws IOException {
        //File file = new File(pPath);
        //file.mkdir();
        //new File(pPath).mkdirs();

        //Ref: https://github.com/coobird/thumbnailator
        Thumbnails.of(pSourceIcon)
                .size(pWidth, pHeight)
                .toFile(pPath + pIconName);
    }

    public static ArrayList<File> getAllImages(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if(files == null || files.length == 0) {
            return null;
        }
        ArrayList<File> imagesList = new ArrayList<>();
        for (File file : files) {
            if( file.isFile() ) {
                if( file.getName().endsWith(".png") ||
                    file.getName().endsWith(".jpg") ||
                    file.getName().endsWith(".jpeg") ||
                    file.getName().endsWith(".gif")
                ){
                    imagesList.add(file);
                }
            }
        }
        return imagesList;
    }

}