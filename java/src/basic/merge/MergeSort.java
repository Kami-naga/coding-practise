package basic.merge;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,8,2,7,6,9,4,2,7};
        mergeSort(a);
        for(int i : a){
            System.out.print(i+" ");
        }
    }

    private static void mergeSort(int[] a) {
        if(a == null || a.length< 2){
            return;
        }
        mergeSort(a, 0, a.length-1);
    }

    private static void mergeSort(int[] a, int L, int R) {
        if(L==R) return;
        int M = L + ((R-L)>>1);
        mergeSort(a, L, M);
        mergeSort(a, M+1, R);
        merge(a, L, M, R);
    }

    private static void merge(int[] a, int L, int M, int R) {
        int[] help = new int[(R - L) + 1];
        int pl = L;
        int pr = M + 1;
        int k = 0;
        while(pl <= M && pr <= R){
            help[k++] = a[pl] < a[pr] ? a[pl++] : a[pr++];
        }

        while(pl <=M){
            help[k++] = a[pl++];
        }
        while(pr <=R){
            help[k++] = a[pr++];
        }
        System.arraycopy(help, 0, a, L, help.length);
    }
}
