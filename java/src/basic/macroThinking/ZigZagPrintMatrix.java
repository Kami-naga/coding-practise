package basic.macroThinking;

//之字形打印矩阵
//1 2 3
//4 5 6
//7 8 9
//则输出为1 2 4 7 5 3 6 8 9
//可以发现它是在沿着斜对角进行打印
//那么如何去表示这个斜对角打印呢？
//控制斜对角线的是右上和左下的两个点
//这两个点中：右上会先不断右移，移到底后再向下
//左下的会不断下移，移到底后再向右
//最后两点交于矩阵右下角点结束
public class ZigZagPrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        zigZagPrintMatrix(matrix);
    }

    private static void zigZagPrintMatrix(int[][] matrix) {
        //矩阵这种row和column和数轴x,y是反过来的（x是col,y是row）就容易搞混，要小心，或者干脆别用下，有这种数轴式的写法
        int sR = 0;
        int sC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        int aR = sR;
        int aC = sC;
        int bR = sR;
        int bC = sC;
        boolean fromTop = false;
        while(aR <= dR && aC <= dC){
            printLine(matrix, aR, aC, bR, bC, fromTop);
            fromTop = !fromTop;
            //顺序有讲究哦
            //先bR后bC就错了，因为到第三行后，bR变3，此时bC应该是0，但会在这里多加一
            aR = aC != dC ? aR : aR + 1;
            aC = aC != dC ? aC + 1 : aC;
            bC = bR != dR ? bC : bC + 1;
            bR = bR != dR ? bR + 1 : bR;
        }
    }

    private static void printLine(int[][] matrix, int aR, int aC, int bR, int bC, boolean fromTop) {
        if(fromTop){
            while(aR <= bR){
                System.out.println(matrix[aR++][aC--]);
            }
        }else{
            while(aR <= bR){
                System.out.println(matrix[bR--][bC++]);
            }
        }
    }


}
