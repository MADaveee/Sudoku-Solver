package filesystem;

import java.io.File;
import java.io.IOException;

public class FileInitializer {

    private String username = System.getProperty("user.name");
    private String path = "C:\\Users\\"+username+"\\Documents\\SudokuSolver\\src";
    private File mainFolder = new File("C:\\Users\\"+username+"\\Documents\\SudokuSolver");
    private File srcFolder = new File("C:\\Users\\"+username+"\\Documents\\SudokuSolver\\src");
    private File imgFolder = new File("C:\\Users\\"+username+"\\Documents\\SudokuSolver\\src\\images");
    private File alreadyShifted = new File(path+"\\shifted.txt");

    public FileInitializer(){
        
        createFileSystem();
    }
    
    private void createFileSystem(){
        
        if(!mainFolder.exists())
            mainFolder.mkdir();
        if(!srcFolder.exists())
            srcFolder.mkdir();
        if(!imgFolder.exists())
            imgFolder.mkdir();
    }
    
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
