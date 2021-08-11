package basic.heap;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,8,2,7,6,9,4,2,7};
        heapSort(a);
        for(int i : a){
            System.out.print(i+" ");
        }
    }

    private static void heapSort(int[] a) {
        if(a == null || a.length < 2){
            return;
        }

        for(int i = 0; i < a.length; i++){
            heapInsert(a, i);
        }

        int heapSize = a.length;
        swap(a, 0, --heapSize);
        while(heapSize > 0){
            heapify(a, 0, heapSize);
            swap(a, 0, --heapSize);
        }
    }

    private static void heapify(int[] a, int index, int heapsize) {
        int left = index * 2 + 1;
        while(left < heapsize){
            int largest = (left+1 < heapsize && a[left+1] > a[left]) ? left+1:left;
            largest = a[index] > a[largest] ? index : largest;
            if(largest == index) break;
            swap(a, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] a, int index) {
        while(a[index] > a[(index-1)/2]){
            swap(a, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    private static void swap(int[] a, int m, int n) {
        if(a[m] == a[n]) return;
        a[m] = a[m] ^ a[n];
        a[n] = a[m] ^ a[n];
        a[m] = a[m] ^ a[n];
    }
}
