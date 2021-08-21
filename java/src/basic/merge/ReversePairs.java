package basic.merge;

public class ReversePairs {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,8,2,7,6,9,4,2,7};
        getReversePairs(a);

    }

    private static void getReversePairs(int[] a) {
        if(a == null || a.length < 2){
            return;
        }
        getReversePairs(a, 0, a.length-1);
    }

    private static void getReversePairs(int[] a, int L, int R) {
        if(L == R) return;

        int M = L + ((R - L) >> 1);
        getReversePairs(a, L, M);
        getReversePairs(a, M+1, R);
        merge(a, L, M, R);
    }

    private static void merge(int[] a, int L, int M, int R) {
        int[] help = new int[R-L+1];
        int pl = L;
        int pr = M + 1;
        int k = 0;

        while(pl <= M && pr <= R){
            if(a[pl] > a[pr]){
                for(int i=pr; i<=R; i++){
                    //注意此处是找逆序对，遍历右侧数组，因此下方39行排序也应该相对应为从大到小
                    System.out.println("pair: "+a[pl]+" "+a[i]);
                }
            }
            help[k++] = a[pl] > a[pr] ? a[pl++] : a[pr++];
        }

        while(pl <= M){
            help[k++] = a[pl++];
        }
        while(pr <= R){
            help[k++] = a[pr++];
        }

        System.arraycopy(help, 0, a, L, help.length);
    }
}
