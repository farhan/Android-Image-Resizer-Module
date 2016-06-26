package com.farhankhan.imageresizer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * @author farhankhan
 * URL: https://github.com/mfarhan133/Android-Image-Resizer-Module
 *
 */
public class ImageResizerMain {

    public static String SEPARATOR = "/";
    public static final String PROJECT_RES_DIRECTORY = "/Users/ YOUR_PROJECT_PATH /MyTestProject/app/src/main/res" + SEPARATOR;

    public static String FOLDER_PREFIX = "drawable-";
    public static final String SOURCE_FOLDER = FOLDER_PREFIX + "xxxhdpi" + SEPARATOR;

    public static void main(String[] args) {
        try {

            ArrayList<File> imagesList = Utils.getAllImages(PROJECT_RES_DIRECTORY + SOURCE_FOLDER);
            if(imagesList == null || imagesList.size() == 0){
                System.out.println("ABORTED: Images directory doesn't contain any image.\nDir:"+ PROJECT_RES_DIRECTORY + SOURCE_FOLDER);
                return;
            }

            /**

             xxxhdpi screen dimension :  1280*1920 px (its mdpi scale becomes 320*480 px which is pretty good)

             Add directories and scale factor to resize images

             Ref: https://developer.android.com/guide/practices/screens_support.html#DesigningResources
             Ref: https://pixplicity.com/dp-px-converter/

                        dp	        px	        sp	        mm	        in	        pt
             ldpi	 @ 0.25dp	= 0.19px	= 0.25sp	= 0.04mm	= 0.00in	= 0.11pt
             mdpi	 @ 0.25dp	= 0.25px	= 0.25sp	= 0.04mm	= 0.00in	= 0.11pt
             tvdpi	 @ 0.25dp	= 0.33px	= 0.25sp	= 0.04mm	= 0.00in	= 0.11pt
             hdpi	 @ 0.25dp	= 0.38px	= 0.25sp	= 0.04mm	= 0.00in	= 0.11pt
             xhdpi	 @ 0.25dp	= 0.50px	= 0.25sp	= 0.04mm	= 0.00in	= 0.11pt
             xxhdpi	 @ 0.25dp	= 0.75px	= 0.25sp	= 0.04mm	= 0.00in	= 0.11pt
             xxxhdpi @ 0.25dp	= 1.00px	= 0.25sp	= 0.04mm	= 0.00in	= 0.11p

             */

            resizeAllImagesTo(FOLDER_PREFIX+"ldpi",    0.19f,  imagesList);
            resizeAllImagesTo(FOLDER_PREFIX+"mdpi",    0.25f,  imagesList);
            //resizeAllImagesTo(FOLDER_PREFIX+"tvdpi",   0.33f,  imagesList);
            resizeAllImagesTo(FOLDER_PREFIX+"hdpi",    0.38f,  imagesList);
            resizeAllImagesTo(FOLDER_PREFIX+"xhdpi",   0.50f,  imagesList);
            resizeAllImagesTo(FOLDER_PREFIX+"xxhdpi",  0.75f,  imagesList);


            System.out.println("\n ******  Images successfully rescaled into their respective directories :) ******\n\n");
        } catch (Exception e) {
            System.out.println("--> ERROR: Some Exception Occurred.");
            System.out.println("--> ERROR: Exception Message: "+ e.getMessage());
            System.out.println("--> ERROR: Stack Trace:");
            e.printStackTrace();
        }
    }

    public static void resizeAllImagesTo(String directory, float scale, ArrayList<File> imagesList){
        final String destinationDirectory = PROJECT_RES_DIRECTORY + directory + SEPARATOR;
        //create new directory
        new File(destinationDirectory).mkdirs();
        //resize all images
        for(File image: imagesList) {
            BufferedImage bufferedImage = null;
            try {
                bufferedImage = ImageIO.read(image);
                int width = bufferedImage.getWidth();
                int height = bufferedImage.getHeight();
                Utils.resizeImageTo (
                    image.getAbsolutePath(),
                    destinationDirectory,
                    image.getName(),
                    (int) (width * scale),
                    (int) (height * scale)
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}