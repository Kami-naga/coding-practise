package basic;

//逆序时最坏O(N^2)，顺序是最好O(N)
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,8,2,7,6,9,4,2,7};
        insertionSort(a);
        for(int i : a){
            System.out.print(i+" ");
        }
    }

    private static void insertionSort(int[] a) {
        if(a == null || a.length < 2) return;
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0; j--){
                if(a[j] < a[j-1]){
                    swap(a, j, j - 1);
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
