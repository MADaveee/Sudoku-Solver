package filesystem;

import java.io.File;
import java.io.IOException;

public class FileInitializer {

    private String username = "david";
    private String path = "C:\\Users\\"+username+"\\Documents\\SudokuSolver\\src";
    private File alreadyShifted = new File(path+"\\shifted.txt");

    public void setShifted(){
        try {
            alreadyShifted.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getShifted(){
        return alreadyShifted.exists();
    }
}
