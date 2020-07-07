package leetCode.ArrayStrings;

public class RotateImageMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = { {1,  2,  3},
                            {4,  5,  6},
                            {7,  8,  9}
                        };
        System.out.println("original Matrix: ");
        printMatrix(matrix1);
        System.out.println("Rotated Matrix");
        rotateMatrix(matrix1);
    }

    private static void printMatrix(int[][] matrix){
        for (int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void rotateMatrix(int[][] matrix){
        //Transpose of matrix
        int size = matrix.length;
       for(int i=0;i<size-1;i++){
           for(int j=i; j<size;j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
           }
       }
       //reverse of Transposed matrix
        for(int i=0;i<size;i++){
            for(int j=0;j<size/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size-1-j];
                matrix[i][size-1-j] = temp;
            }
        }

        printMatrix(matrix);
    }
}
