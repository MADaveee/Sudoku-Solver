package utility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Interpretation {
private ImageCracker imageCracker;
private Backtracking backtracking;

    public Interpretation(ImageCracker imageCracker, Backtracking backtracking){
        this.imageCracker = imageCracker;
        this.backtracking = backtracking;

    }

    private int row = 9;
    private int column = 9;
    public int[][] givenDigits(String filepath){
        int[][] ret = new int[row][column];
        int[] buffer = new int[81];
        BufferedImage[] imgs = new BufferedImage[81];
        try {
            imgs = imageCracker.splitImage(imageCracker.colorToAlpha(ImageIO.read(new File(filepath))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0;i<81;i++) {

            String s = imageCracker.extractDigitOutOfImg(imgs[i]);

            if (s.contains("1"))
                buffer[i] = 1;
            else if (s.contains("l"))
                buffer[i] = 1;
            else if (s.contains("2"))
                buffer[i] = 2;
            else if (s.contains("3"))
                buffer[i] = 3;
            else if (s.contains("4"))
                buffer[i] = 4;
            else if (s.contains("5"))
                buffer[i] = 5;
            else if (s.contains("6"))
                buffer[i] = 6;
            else if (s.contains("7"))
                buffer[i] = 7;
            else if (s.contains("8"))
                buffer[i] = 8;
            else if (s.contains("9"))
                buffer[i] = 9;
            else
                buffer[i] = 0;
        }

        int k = 0;
        for(int i = 0;i<9;i++){
            for(int n = 0;n<9;n++){
                ret[n][i] = buffer[k];
                k++;
            }
        }

        return ret;
    }

    public int[][] solvingAlgorithm(int[][] reference){
        if (backtracking.solveSudoku(reference, reference.length))
            return backtracking.getSolvedBoard(reference);
        else
            return null;
    }

}