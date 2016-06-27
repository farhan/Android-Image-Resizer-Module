# Android-Image-Resizer-Module
You can add this module in any of your android studio project and easily resize all the high res icons into low res in one click.

Super easy isn't it ?

### Quick Demo Steps:
1. Download the project and open "MyTestProject" project into android studio. Intially project will only contain xxxhdpi density images.
2. Right click on res folder of project and copy path, path will be like "~/MyTestProject/app/src/main/res".
3. Open "com.farhankhan.imageresizer.ImageResizerMain" class of "AndroidImageResizer" module and paste the path in PROJECT_RES_DIRECTORY field of class.
4. Right click on "ImageResizerMain" class and select "Run ImageResizerMain.main()" option. Thats it!

### Output:
On success run you will see new directories of densities are created other than xxxhdpi and these density directories also contain resized images. Wow!!! Life become super easy now ;)

### Note:
You can also modify the code according to your need and suggest the improvements so the changes go to all clients of code.
