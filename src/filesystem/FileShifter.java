package filesystem;

import java.io.File;

public class FileShifter {
private final FileInitializer fileInitializer;

    public FileShifter(FileInitializer fileInitializer){
        this.fileInitializer = fileInitializer;

        shiftFiles();
    }

    private final String username = "david";
    private final String pathdest = "C:\\Users\\"+username+"\\Documents\\SudokuSolver\\src\\images";
    private final String pathsrc = "C:\\Users\\"+username+"\\Downloads\\Sudoku-Solver-Installer\\src\\images";


    public final File exit_dest = new File(pathdest+"\\exit.png");
    public final File exit_selected_dest  = new File(pathdest+"\\exit_selected.png");
    public final File horizontalline_dest  = new File(pathdest+"\\horizontalline.png");
    public final File load_sudoku_dest  = new File(pathdest+"\\load_sudoku.png");
    public final File load_sudoku_selected_dest  = new File(pathdest+"\\load_sudoku_selected.png");
    public final File solve_sudoku_dest = new File(pathdest+"\\solve_sudoku.png");
    public final File solve_sudoku_selected_dest  = new File(pathdest+"\\solve_sudoku_selected.png");
    public final File verticalline_dest  = new File(pathdest+"\\verticalline.png");
    public final File verticallinebold_dest = new File(pathdest+"\\verticallinebold.png");
    public final File horizontallinebold_dest = new File(pathdest+"\\horizontallinebold.png");
    public final File enter_digits_dest = new File(pathdest+"\\enter_digits.png");
    public final File enter_digits_selected_dest = new File(pathdest+"\\enter_digits_selected.png");
    public final File enter_dest = new File(pathdest+"\\enter.png");
    public final File enter_selected_dest = new File(pathdest+"\\enter_selected.png");

    private final File exit_src = new File(pathsrc+"\\exit.png");
    private final File exit_selected_src = new File(pathsrc+"\\exit_selected.png");
    private final File horizontalline_src = new File(pathsrc+"\\horizontalline.png");
    private final File load_sudoku_src = new File(pathsrc+"\\load_sudoku.png");
    private final File load_sudoku_selected_src = new File(pathsrc+"\\load_sudoku_selected.png");
    private final File solve_sudoku_src = new File(pathsrc+"\\solve_sudoku.png");
    private final File solve_sudoku_selected_src = new File(pathsrc+"\\solve_sudoku_selected.png");
    private final File verticalline_src = new File(pathsrc+"\\verticalline.png");
    public final File verticallinebold_src = new File(pathsrc+"\\verticallinebold.png");
    public final File horizontallinebold_src = new File(pathsrc+"\\horizontallinebold.png");
    public final File enter_digits_src = new File(pathsrc+"\\enter_digits.png");
    public final File enter_digits_selected_src = new File(pathsrc+"\\enter_digits_selected.png");
    public final File enter_src = new File(pathsrc+"\\enter.png");
    public final File enter_selected_src = new File(pathsrc+"\\enter_selected.png");

    public void shiftFiles(){

        if(!fileInitializer.getShifted()) {
            exit_src.renameTo(exit_dest);
            exit_selected_src.renameTo(exit_selected_dest);
            horizontalline_src.renameTo(horizontalline_dest);
            load_sudoku_src.renameTo(load_sudoku_dest);
            load_sudoku_selected_src.renameTo(load_sudoku_selected_dest);
            solve_sudoku_src.renameTo(solve_sudoku_dest);
            solve_sudoku_selected_src.renameTo(solve_sudoku_selected_dest);
            verticalline_src.renameTo(verticalline_dest);
            verticallinebold_src.renameTo(verticallinebold_dest);
            horizontallinebold_src.renameTo(horizontallinebold_dest);
            enter_digits_src.renameTo(enter_digits_dest);
            enter_digits_selected_src.renameTo(enter_digits_selected_dest);
            enter_src.renameTo(enter_dest);
            enter_selected_src.renameTo(enter_selected_dest);

            fileInitializer.setShifted();
        }

    }
}
