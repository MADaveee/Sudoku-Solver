package utility;

import java.awt.*;
import java.awt.image.BufferedImage;

import net.sourceforge.tess4j.*;

public class ImageCracker {

    public String extractDigitOutOfImg(BufferedImage img) {

        ITesseract instance = new Tesseract();

        try {
            return instance.doOCR(img);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
            return "Error while reading image";
        }
    }

    public BufferedImage[] splitImage(BufferedImage img){

        BufferedImage[] buffer = new BufferedImage[81];
        BufferedImage[] cropped = new BufferedImage[81];
        BufferedImage image = img;

        int width = image.getWidth()/9;
        int height = image.getHeight()/9;

        int x = 0;
        int y = 0;

        for(int i = 0;i<buffer.length;i++){

            if(x<=image.getWidth()){
                buffer[i] = image.getSubimage(x, y, width, height);
            }

            if(x >= image.getWidth()-10) {
                y += height;
                x = 0;
            }else if(x+width>=image.getWidth()-10){
                y += height;
                x = 0;
            }else{
                x += width;
            }

        }

        int newX = (11*width)/100;
        int newY = (11*height)/100;
        int newWidth = width-((20*width)/100);
        int newHeight = height-((20*height)/100);

        for(int i = 0;i<buffer.length;i++)
            cropped[i] = buffer[i].getSubimage(newX,newY,newWidth, newHeight);

        return cropped;
    }

    public BufferedImage colorToAlpha(BufferedImage raw) {
        int WIDTH = raw.getWidth();
        int HEIGHT = raw.getHeight();

        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);

        int[] pixels = new int[WIDTH*HEIGHT];

        Color color1 = new Color(0x000000);
        Color color2 = new Color(0x2F2F32);

        raw.getRGB(0, 0, WIDTH, HEIGHT, pixels, 0, WIDTH);

        for(int i = 0; i<pixels.length;i++) {
            if (!(isBetween(pixels[i], color1.getRGB(), color2.getRGB()))) {
                pixels[i] = 0x00ffffff;
            }
        }

        image.setRGB(0, 0, WIDTH, HEIGHT, pixels, 0, WIDTH);
        return image;
    }

    private boolean isBetween(int i, int minValueInclusive, int maxValueInclusive) {
        return i >= minValueInclusive && i <= maxValueInclusive;
    }
}