package com.farhankhan.imageresizer;

import java.io.File;
import java.io.IOException;

/**
 * @author farhankhan
 * URL: https://github.com/mfarhan133/Android-Image-Resizer-Module
 *
 */
public class IconResizerMain {

    public static String SEPARATOR = "/";

    public static final String SOURCE_ICON_512x512 = "YOUR_PROJECT_PATH/MyTestProject/app/src/main/ic_launcher-web.png";
    public static final String PROJECT_RES_DIRECTORY = "YOUR_PROJECT_PATH/MyTestProject/app/src/main/res" + SEPARATOR;

    public static final String ICON_NAME = "ic_launcher.png";

    public static void main(String[] args) {
        try {

            //Ref: https://developer.android.com/guide/practices/ui_guidelines/icon_design_launcher.html#size

            createIcon("mipmap-ldpi",    32,  32);
            createIcon("mipmap-mdpi",    48,  48);
            createIcon("mipmap-hdpi",    72,  72);
            createIcon("mipmap-xhdpi",   96,  96);
            createIcon("mipmap-xxhdpi",  144, 144);
            createIcon("mipmap-xxxhdpi", 192, 192);

            System.out.println("\n ****** All different res icons created successfully :) ******\n\n");
        } catch (Exception e) {
            System.out.println("--> ERROR: Some Exception Occurred.");
            System.out.println("--> ERROR: Exception Message: "+ e.getMessage());
            System.out.println("--> ERROR: Stack Trace:");
            e.printStackTrace();
        }
    }

    public static void createIcon(String directory, int width, int height) {
        final String destinationDirectory = PROJECT_RES_DIRECTORY + directory + SEPARATOR;
        //create new directory
        new File(destinationDirectory).mkdirs();
        //resize icon
        try {
            Utils.resizeImageTo (
                SOURCE_ICON_512x512,
                destinationDirectory,
                ICON_NAME,
                width,
                height
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
