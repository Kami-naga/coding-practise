package basic.partition;

//时间复杂度O(nlogn),分得很不平均时有最差情况O(N^2)
//空间复杂度O(logn)->记录分割点，分得很不平均时有最差情况O(N)
public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,8,2,7,6,9,4,2,7};
        quickSort(a);
        for(int i : a){
            System.out.print(i+" ");
        }
    }

    private static void quickSort(int[] a) {
        if(a == null || a.length <2){
            return;
        }
        quickSort(a, 0, a.length-1);
    }

    private static void quickSort(int[] a, int L, int R) {
        if(L < R){
            swap(a, R, L + (int)(Math.random()*(R-L+1)));
            int[] p = partition(a, L, R);
            quickSort(a, L, p[0] - 1);
            quickSort(a, p[1]+1, R);
        }
    }

    private static void swap(int[] a, int m, int n) {
        if(a[m] == a[n]) return;
        a[m] = a[m] ^ a[n];
        a[n] = a[m] ^ a[n];
        a[m] = a[m] ^ a[n];
    }

    private static int[] partition(int[] a, int L, int R) {
        int less = L - 1;
        int more = R;
        int cur = L;
        while(cur < more){
            if(a[cur] < a[R]){
                swap(a, ++less, cur++);
            }else if(a[cur] > a[R]){
                swap(a, --more, cur);
            }else{
                cur++;
            }
        }
        swap(a, more, R);
        return new int[]{less + 1, more};
    }


}
