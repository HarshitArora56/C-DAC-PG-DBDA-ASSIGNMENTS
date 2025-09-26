import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

class Matrix {
    private int rows;
    private int cols;
    private int[][] elements;

    Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        elements = new int[rows][cols];
    }

    public int getRows(){
        return rows;
    }
    public int getCols(){
        return cols;
    }
    public void setElements(int i, int j, int value){
        if(i >= 0 && i < rows && j >= 0 && j < cols){
            elements[i][j] = value;
        }
    }

    public static Matrix addMatrices(@NotNull Matrix m1, @NotNull Matrix m2){
        if((m1.getRows() != m2.getRows()) && (m1.getCols() != m2.getCols())){
            System.out.println("Matrices cannot be Added!");
            return null;
        }
        Matrix resultMatrix = new Matrix(m1.rows, m1.cols);
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getCols(); j++) {
                resultMatrix.setElements(i,j, m1.elements[i][j] + m2.elements[i][j]);
            }
        }
        return resultMatrix;
    }
    void display(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println();
        }
    }

}

public class MatrixCal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of Cols: ");
        int cols = sc.nextInt();

        Matrix a = new Matrix(rows, cols);
        Matrix b = new Matrix(rows, cols);

        System.out.println("Enter Values for Matrix A: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value =  sc.nextInt();
                a.setElements(i, j, value);
            }
        }

        System.out.println("Enter Values for Matrix B: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value =  sc.nextInt();
                b.setElements(i, j, value);
            }
        }
        System.out.println("Matrix A: ");
        a.display();
        System.out.println("Matrix B: ");
        b.display();

        System.out.println("Adding Matrix A & B...");
        Matrix result = Matrix.addMatrices(a,b);
        if (result != null){
            result.display();
        }


    }
}
