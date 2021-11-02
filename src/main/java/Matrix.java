public class Matrix{
    int numberofrows;
    int numberofcolumns;
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
        int nosCols = matrix.length;
        return nosCols;
    }

    public int GetNuberofRows() {
        int nosRows = matrix[0].length;
        return nosRows;
    }

}
