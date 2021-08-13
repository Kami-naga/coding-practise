package basic.macroThinking;

//顺时针从外到内打印矩阵
//这种题若是细节部（矩阵坐标）入手，便会发现处理很麻烦很容易错，所以要从宏观角度进行考虑
//只需左上，右下两个点便可确定一个圈
//顺时针打印矩阵，可以分解成从外到内一圈一圈地打印矩阵，
//所以只需要做好打印一圈数的操作&外圈到内圈的变换操作，打印矩阵也就手到拈来了
public class PrintMatrixSpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);
    }

    private static void spiralOrderPrint(int[][] matrix) {
        int sR = 0;
        int sC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while(sR <= dR && sC <= dC){
            //外圈到内圈的变换操作:左上和右下的点分别朝内缩一格，当左上行或列大于右下时即结束
            printCircle(sR++, sC++, dR--, dC--, matrix);
        }
    }

    private static void printCircle(int sR, int sC, int dR, int dC, int[][] matrix) {
        if(sR == dR){
            //打印的矩阵只有一行
            for(int i = sC; i <= dC; i++){
                System.out.println(matrix[sR][i]);
            }
        }else if(sC == dC){
            //打印的矩阵只有一列
            for(int i = sR; i <= dR; i++){
                System.out.println(matrix[i][sC]);
            }
        }else{//顺时针绕圈打印
            //该行or列最后一个元素亦为另一列or行的第一个元素，所以为了防止重复打印，最后一个不取
            for(int i = sC;i < dC; i++){
                System.out.println(matrix[sR][i]);
            }
            for(int i = sR;i < dR; i++){
                System.out.println(matrix[i][dR]);
            }
            for(int i = dC;i > sC; i--){
                System.out.println(matrix[dR][i]);
            }
            for(int i = dR;i > sR; i--){
                System.out.println(matrix[i][sC]);
            }
        }
    }
}
