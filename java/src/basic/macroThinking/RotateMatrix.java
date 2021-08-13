package basic.macroThinking;

//顺时针旋转正方形矩阵90°
//同样的，若去搞那些坐标，会很繁琐，所以来点宏观思维
//和顺时针打印矩阵类似，他这个旋转也可以看作是一圈一圈的操作
//每一圈的操作就是四个边上相对应位置的一组点去进行移动
//所以一圈的操作可以看作是一条边上对应点的赋值操作
//动完了缩圈
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("=========");
        printMatrix(matrix);
    }

    private static void rotateMatrix(int[][] matrix) {
        int sR = 0;
        int sC = 0;
        int dR = matrix.length-1;
        int dC = matrix[0].length-1;
        while(sR < dR){
            rotateCircle(sR++, sC++, dR--, dC--, matrix);
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateCircle(int sR, int sC, int dR, int dC, int[][] matrix) {
        int i = 0;
        while(sC + i < dC){
            int tmp = matrix[sR][sC+i];
            matrix[sR][sC+i] = matrix[dR-i][sC];
            matrix[dR-i][sC] = matrix[dR][dC-i];
            matrix[dR][dC-i] = matrix[sR+i][dC];
            matrix[sR+i][dC] = tmp;
            i++;
        }
    }
}
