package gui;

import filesystem.FileShifter;
import utility.Interpretation;

import javax.swing.*;
import java.awt.*;

public class Window {
private final Interpretation interpretation;
private final FileShifter fileShifter;

    public Window(Interpretation interpretation, FileShifter fileShifter){
        this.interpretation = interpretation;
        this.fileShifter = fileShifter;

        initWindow();
    }

    private JFrame f;
    private JPanel main_p, manual_p;
    private JLabel[][] sudokuboard = new JLabel[9][9];
    private ImageIcon verticalLines_i, horizontalLines_i, verticallinesbold_i, horizontallinesbold_i;
    private ImageIcon loadsudoku_i, solvesudoku_i, enterdigits_i, exit_i, loadsudokuselected_i, solvesudokuselected_i, enterdigitsselected_i, exitselected_i;
    private ImageIcon enter_i, enterselected_i;
    private JLabel[] verticalLines = new JLabel[8];
    private JLabel[] horizontalLines = new JLabel[8];
    private JLabel[] verticallinesbold = new JLabel[3];
    private JLabel[] horizontallinesbold = new JLabel[3];
    private JButton solveSudoku, loadSudoku, enterDigits, exit;

    private JButton enter;
    private JTextField[][] textFields = new JTextField[9][9];
    private int[][] digits = new int[9][9];
    private void initWindow(){
        f = new JFrame();
        f.setLayout(null);
        f.setSize(1200,800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);

        main_p = new JPanel();
        main_p.setBounds(0,0,1200,800);
        main_p.setLayout(null);
        main_p.setBackground(Color.DARK_GRAY);

        manual_p = new JPanel();
        manual_p.setBounds(0,0,1200,800);
        manual_p.setLayout(null);
        manual_p.setBackground(Color.DARK_GRAY);

        setContentMain_p(main_p);
        setMain_p(main_p);

        f.add(main_p);
        f.add(manual_p);
        f.setVisible(true);
    }

    private void setContentMain_p(JPanel main_p){

        main_p.removeAll();

        for(int i = 0;i<sudokuboard.length;i++){
            for(int n = 0;n<sudokuboard.length;n++){

                sudokuboard[i][n] = new JLabel(String.valueOf(digits[i][n]));
                sudokuboard[i][n].setFont(new Font("Arial Black", Font.PLAIN, 20));
                sudokuboard[i][n].setBounds(60+(i*60),100+(n*60),30,30);
                sudokuboard[i][n].setForeground(Color.WHITE);

                main_p.add(sudokuboard[i][n]);
            }
        }

        verticalLines_i = new ImageIcon(String.valueOf(fileShifter.verticalline_dest));
        horizontalLines_i = new ImageIcon(String.valueOf(fileShifter.horizontalline_dest));
        verticallinesbold_i = new ImageIcon(String.valueOf(fileShifter.verticallinebold_dest));
        horizontallinesbold_i = new ImageIcon(String.valueOf(fileShifter.horizontallinebold_dest));

        int k = 0;
        for(int i = 0;i<verticalLines.length;i++){

            verticalLines[i] = new JLabel(verticalLines_i);
            verticalLines[i].setBounds(95+(i*60),85,2,540);

            horizontalLines[i] = new JLabel(horizontalLines_i);
            horizontalLines[i].setBounds(40,145+(i*60),540,2);

            if(i%3==2){
                verticallinesbold[k] = new JLabel(verticallinesbold_i);
                verticallinesbold[k].setBounds(95+(i*60),85,6,540);

                horizontallinesbold[k] = new JLabel(horizontallinesbold_i);
                horizontallinesbold[k].setBounds(40,145+(i*60),540,6);

                main_p.add(verticallinesbold[k]);
                main_p.add(horizontallinesbold[k]);
                k++;
            }

            main_p.add(verticalLines[i]);
            main_p.add(horizontalLines[i]);
        }

        loadsudoku_i = new ImageIcon(String.valueOf(fileShifter.load_sudoku_dest));
        solvesudoku_i = new ImageIcon(String.valueOf(fileShifter.solve_sudoku_dest));
        enterdigits_i = new ImageIcon(String.valueOf(fileShifter.enter_digits_dest));
        exit_i = new ImageIcon(String.valueOf(fileShifter.exit_dest));
        loadsudokuselected_i = new ImageIcon(String.valueOf(fileShifter.load_sudoku_selected_dest));
        solvesudokuselected_i = new ImageIcon(String.valueOf(fileShifter.solve_sudoku_selected_dest));
        enterdigitsselected_i = new ImageIcon(String.valueOf(fileShifter.enter_digits_selected_dest));
        exitselected_i = new ImageIcon(String.valueOf(fileShifter.exit_selected_dest));

        loadSudoku = new JButton(loadsudoku_i);
        loadSudoku.setRolloverIcon(loadsudokuselected_i);
        loadSudoku.setContentAreaFilled(false);
        loadSudoku.setBorder(null);
        loadSudoku.setBounds(1000,30,150,30);
        loadSudoku.addActionListener((e)->{

            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showOpenDialog(null);
            digits = interpretation.givenDigits(jFileChooser.getSelectedFile().toString());

            for(int i = 0;i<sudokuboard.length;i++)
                for(int n = 0;n<sudokuboard.length;n++)
                    sudokuboard[i][n].setText(String.valueOf(digits[i][n]));

        });

        solveSudoku = new JButton(solvesudoku_i);
        solveSudoku.setRolloverIcon(solvesudokuselected_i);
        solveSudoku.setContentAreaFilled(false);
        solveSudoku.setBorder(null);
        solveSudoku.setBounds(1000,80,150,30);
        solveSudoku.addActionListener((e)->{
            digits = interpretation.solvingAlgorithm(digits);

            for(int i = 0;i<sudokuboard.length;i++)
                for(int n = 0;n<sudokuboard.length;n++)
                    sudokuboard[i][n].setText(String.valueOf(digits[i][n]));
        });

        enterDigits = new JButton(enterdigits_i);
        enterDigits.setRolloverIcon(enterdigitsselected_i);
        enterDigits.setContentAreaFilled(false);
        enterDigits.setBorder(null);
        enterDigits.setBounds(1000,130,150,30);
        enterDigits.addActionListener((e)->{
            determinateMain_p(main_p);
            setContentManual_p(manual_p);
            setManual_p(manual_p);
        });

        exit = new JButton(exit_i);
        exit.setRolloverIcon(exitselected_i);
        exit.setContentAreaFilled(false);
        exit.setBorder(null);
        exit.setBounds(1000,180,150,30);
        exit.addActionListener((e)-> System.exit(0));

        main_p.add(loadSudoku);
        main_p.add(solveSudoku);
        main_p.add(enterDigits);
        main_p.add(exit);
    }

    private void setContentManual_p(JPanel manual_p){

        manual_p.removeAll();

        verticalLines_i = new ImageIcon(String.valueOf(fileShifter.verticalline_dest));
        horizontalLines_i = new ImageIcon(String.valueOf(fileShifter.horizontalline_dest));
        verticallinesbold_i = new ImageIcon(String.valueOf(fileShifter.verticallinebold_dest));
        horizontallinesbold_i = new ImageIcon(String.valueOf(fileShifter.horizontallinebold_dest));

        int k = 0;
        for(int i = 0;i<verticalLines.length;i++){

            verticalLines[i] = new JLabel(verticalLines_i);
            verticalLines[i].setBounds(95+(i*60),85,2,540);

            horizontalLines[i] = new JLabel(horizontalLines_i);
            horizontalLines[i].setBounds(40,145+(i*60),540,2);

            if(i%3==2){
                verticallinesbold[k] = new JLabel(verticallinesbold_i);
                verticallinesbold[k].setBounds(95+(i*60),85,6,540);

                horizontallinesbold[k] = new JLabel(horizontallinesbold_i);
                horizontallinesbold[k].setBounds(40,145+(i*60),540,6);

                manual_p.add(verticallinesbold[k]);
                manual_p.add(horizontallinesbold[k]);
                k++;
            }

            manual_p.add(verticalLines[i]);
            manual_p.add(horizontalLines[i]);
        }

        for(int i = 0;i<textFields.length;i++){
            for(int n = 0;n<textFields.length;n++){

                textFields[i][n] = new JTextField(String.valueOf(digits[i][n]));
                textFields[i][n].setFont(new Font("Arial Black", Font.PLAIN, 20));
                textFields[i][n].setBounds(50+(i*60),100+(n*60),30,30);
                textFields[i][n].setForeground(Color.BLACK);

                manual_p.add(textFields[i][n]);
            }
        }

        enter_i = new ImageIcon(String.valueOf(fileShifter.enter_dest));
        enterselected_i = new ImageIcon(String.valueOf(fileShifter.enter_selected_dest));

        enter = new JButton(enter_i);
        enter.setRolloverIcon(enterselected_i);
        enter.setContentAreaFilled(false);
        enter.setBorder(null);
        enter.setBounds(1000,30,150,30);
        enter.addActionListener((e)->{

            for(int i = 0;i<textFields.length;i++)
                for(int n = 0;n<textFields.length;n++)
                    digits[i][n] = Integer.parseInt(textFields[i][n].getText());

            determinateManual_p(manual_p);
            setContentMain_p(main_p);
            setMain_p(main_p);

        });

        manual_p.add(enter);
    }

    private void setMain_p(JPanel main_p){
        main_p.setVisible(true);
    }

    private void determinateMain_p(JPanel main_p){
        main_p.setVisible(false);
    }

    private void setManual_p(JPanel manual_p){
        manual_p.setVisible(true);
    }

    private void determinateManual_p(JPanel manual_p){
        manual_p.setVisible(false);
    }
}