package basic.binarySearch;

import java.util.Arrays;

public class binarySearch {
    public static void main(String[] args) {
        int[] a = new int[]{3,8,10,5,8,2,7,5,6,9,3,6,9,4,2,7,1};
        System.out.println(find(a, 1));
    }

    private static boolean find(int[] a, int k) {
        Arrays.sort(a);
        if(a == null) return false;
        if(a.length < 2) return a[0] == k;

        int L = 0;
        int R = a.length - 1;
        while(L <= R){
            int M = L + ((R - L) >> 1);
            if(a[M] == k){
                return true;
            }else if(a[M] < k){
                L = M + 1;
            }else{
                R = M - 1;
            }
        }
        return false;
    }
}
