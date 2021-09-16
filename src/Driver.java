import filesystem.FileInitializer;
import filesystem.FileShifter;
import utility.Backtracking;
import utility.ImageCracker;
import utility.Interpretation;
import gui.Window;

public class Driver {

        public static void main(String[] args) {

                FileInitializer fileInitializer = new FileInitializer();

                FileShifter fileShifter = new FileShifter(fileInitializer);

                Backtracking backtracking = new Backtracking();

                ImageCracker imageCracker = new ImageCracker();

                Interpretation interpretation = new Interpretation(imageCracker, backtracking);

                Window window = new Window(interpretation, fileShifter);
        }

}