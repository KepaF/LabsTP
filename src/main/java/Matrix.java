import java.io.*;
import java.util.Scanner;

public class Matrix {
    private int numberofrows;
    private int numberofcolumns;
    private static double[][] matrix;

    public double[][] getMarix() {

        return matrix;
    }

    public void setMatrix(double[][] newMatrix) {
        matrix = newMatrix;
    }
    //конструктор класса с 2-мя параметрами
    public Matrix(int numberofrows,int numberofcolumns) throws FileNotFoundException {
        this.numberofrows = numberofrows;
        this.numberofcolumns = numberofcolumns;
    }
    //два метода возр кол-во строк и кол-во столбцов соотв
    public int GetNuberofColumns() {
        return numberofcolumns;
    }

    public int GetNuberofRows() {
        return numberofrows;
    }
    public void setElements(int a, int b, double newValue) {

        matrix[a][b] = newValue;
    }
    public double getElements(int a, int b) {//метод реализует отдельное добавление

        return matrix [a][b];
    }
    public static double[][] MatrixMulti(double[][] MatrixA,double[][] MatrixB) {//умножение матриц
        int m = MatrixA.length;
        int n = MatrixB[0].length;
        int o = MatrixB.length;
        double[][] result = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    result[i][j] += MatrixA[i][k] * MatrixB[k][j];
                    return result;
                }
            }
        }
        return result;
    }

    File file = new File("file.txt");
    
    FileReader fileReader = new FileReader(file);
    public static void writeToFile(FileWriter fileWriter, Matrix matrix)throws IOException {
        try {
            fileWriter.write(matrix.GetNuberofRows() + "\n");
            fileWriter.write(matrix.GetNuberofColumns() + "\n");
            fileWriter.write(matrix.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFile(FileReader fileReader){
        StreamTokenizer streamTokenizer = new StreamTokenizer(fileReader);
        try{
            streamTokenizer.nextToken();
            int rows = (int)streamTokenizer.nval;
            streamTokenizer.nextToken();
            int columns = (int)streamTokenizer.nval;
            if (rows < 0 || columns < 0) {
                throw new IllegalArgumentException("Одна (или обе) размерности меньше нуля");
            }
            streamTokenizer.nextToken();
            Matrix m = new Matrix(rows, columns);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                        m.setElements (i ,j ,streamTokenizer.nval);
                        streamTokenizer.nextToken();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }










}

