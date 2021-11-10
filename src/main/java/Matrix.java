import java.io.*;
import java.util.Scanner;

public class Matrix {
    private int numberofrows;
    private int numberofcolumns;
    private double[][] matrix;

    public double[][] getMarix() {

        return matrix;
    }

    public void setMatrix(double[][] newMatrix) {
        matrix = newMatrix;
    }
    //конструктор класса с 2-мя параметрами
    public Matrix(int numberofrows,int numberofcolumns){
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

    public static void writeToFile(FileWriter fileWriter, Matrix matrix) {
        try {
            fileWriter.write(matrix.GetNuberofRows() + "\n");
            fileWriter.write(matrix.GetNuberofColumns() + "\n");
            fileWriter.write(matrix.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








    public static void writeMatrix(double [][] matrix) throws IOException {


        try {
            OutputStream output = new FileOutputStream("file.txt"); // Создание текстового файла
            for(int j=0;j<matrix[0].length;j++) {
                for (int i = 0; i < matrix.length; i++) {
                    output.write(matrix[i][j]); // Запись каждого символа в текстовый файл
                }
            }
            output.close();

            InputStream input = new FileInputStream("file.txt");
            int size = input.available();

            for(int j = 0; j < size; j++) {
                System.out.print((char)input.read() + " "); // Чтение текстового файла посимвольно
            }
            input.close();

        }catch(IOException e) {
            System.out.print("Exception");
        }
    }
}

