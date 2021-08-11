package basic.merge;

//input: [1,3,5,2,7]
//1<3, 1
//1<5, 1
//3<5, 3
//1<2, 1
//1<7, 1
//3<7, 3
//5<7, 5
//2<7, 2
//output:1+1+3+1+1+3+5+2 = 17
public class SmallSum {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,2,7};
        System.out.println(smallSum(a));
    }

    private static int smallSum(int[] a) {
        if(a == null || a.length<2){
            return 0;
        }
        return smallSum(a, 0, a.length-1);
    }

    private static int smallSum(int[] a, int L, int R) {
        if(L == R) return 0;

        int M = L + ((R - L)>>1);
        int leftSum  = smallSum(a, L, M);
        int rightSum  = smallSum(a, M+1, R);
        return leftSum + rightSum + merge(a, L, M, R);
    }

    private static int merge(int[] a, int L, int M, int R) {
        int[] help = new int[R-L+1];
        int pl = L;
        int pr = M + 1;
        int k = 0;

        int result = 0;
        while(pl <= M && pr <= R){
            result += a[pl] < a[pr] ? a[pl]*(R-pr+1) : 0; //注意这里是pr而不是M，每次循环，之前算过的要去掉，而不是每次都是all in
            help[k++] = a[pl] < a[pr] ? a[pl++] : a[pr++];
        }

        while(pl <= M){
            help[k++] = a[pl++];
        }
        while(pr <= R){
            help[k++] = a[pr++];
        }

//        for(int i=0;i< help.length;i++){
//            a[L+i] = help[i];
//        }
        System.arraycopy(help, 0, a, L, help.length);
        System.out.println(result);
        return  result;
    }
}
