package basic;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,8,2,7,6,9,4,2,7};
        selectionSort(a);
        for(int i : a){
            System.out.print(i+" ");
        }
    }

    private static void selectionSort(int[] a) {
        if(a == null || a.length<2){
            return;
        }
        for(int i = 0; i < a.length; i++){
            int min = i;
            for(int j = i+1; j < a.length;j++){
                if(a[min] > a[j]){
                    min = j;
                }
            }
            swap(a, min, i);
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
