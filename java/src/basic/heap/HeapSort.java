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

        //O(nlogn)建堆
        //若他是一个元素一个元素给这样的，那只能这样
        //但如果他是一下子把所有元素给你（像heapsort这样直接丢你一个数组），那用下边方法:从下而上heapify更快
//        for(int i = 0; i < a.length; i++){ //O(n)
//            heapInsert(a, i);  //O(logn)
//        }

        for(int i = a.length - 1;i >= 0; i--){ //O(n)
            //T(n) = n/2*1+n/4*2+n/8*3+...
            //2T(n) = n   +n/2*2+n/4*3+...
            //错项相减
            //T(n) = n + n/2 + n/4 + n/8 + .... = n * (1+1/2+1/4+1/8+...)
            //所以是O(n)
            heapify(a, i, a.length);
        }

        int heapSize = a.length;
        swap(a, 0, --heapSize);
        while(heapSize > 0){ //O(n)
            heapify(a, 0, heapSize); //O(logn)
            swap(a, 0, --heapSize);  //O(1)
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
