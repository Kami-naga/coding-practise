package basic.heap;

import java.util.PriorityQueue;

public class SortArrayDistanceLessK {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,2,5,6,4,8,9,7};
        sortArrayDistanceLessK(a, 2);
        for(int i : a){
            System.out.print(i + " ");
        }
    }

    private static void sortArrayDistanceLessK(int[] a, int k) {
        if(a == null || a.length < 2) return;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i = 0;
        int input = 0;
        for(; i < Math.min(a.length, k); i++){ //有人捣乱，k可能会特别大，所以取小的保证不越界
            heap.add(a[i]);
        }
        while(i < a.length){
            heap.add(a[i++]);
            a[input++] = heap.poll();
        }
        while(!heap.isEmpty()){
            a[input++] = heap.poll();
        }
    }
}
