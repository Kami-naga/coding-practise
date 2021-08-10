package basic;


//桶排序之计数排序 counting sort
//对排序数据有要求，因为他是排序值映射数组空间，所以其最大值不能很大，否则就要建一个超长的数组了
public class CountingSort {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,8,2,7,6,9,4,2,7};
        countingSort(a);
        for(int i : a){
            System.out.print(i+" ");
        }
    }

    private static void countingSort(int[] a) {
        if(a==null || a.length < 2) return;

        int max = Integer.MIN_VALUE;
        for(int i : a){
           max = Math.max(i, max);
        }

        int[] buckets = new int[max+1];
        for (int j : a) {
            buckets[j]++;
        }

        int index = 0;
        for(int i = 0;i < buckets.length;i++){
            while(buckets[i]-- != 0){
                a[index++] = i;
            }
        }
    }
}
