package basic;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,8,2,7,6,9,4,2,7};
        bubbleSort(a);
        for(int i : a){
            System.out.print(i+" ");
        }
    }

    public static void bubbleSort(int[] a) {
        if(a == null || a.length<2){
            return;
        }
        for(int i = a.length - 1; i >= 0; i--){
            for(int j = 0;j < i;j++){
                if(a[j+1] < a[j]){
                    swap(a, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] a, int m, int n) {
        if(a[m] != a[n]){
            a[m] = a[m] ^ a[n];
            a[n] = a[m] ^ a[n];
            a[m] = a[m] ^ a[n];
        }
    }
}
