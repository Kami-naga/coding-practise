package basic.bucket;


//桶排序之计数排序 counting sort
//对排序数据有要求，因为他是排序值映射数组空间，所以其最大值不能很大，否则就要建一个超长的数组了
public class CountingSort {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,8,2,7,6,9,4,2,7};
        countingSort2(a);
        for(int i : a){
            System.out.print(i+" ");
        }
    }

    private static void countingSort1(int[] a) {
        //这种先找max，然后根据max确定桶的数量再一个桶一个计数的方法确实可以实现排序
        //但这样会失去排序稳定性，即计数完毕后组成排序数组时，同样值的元素，不知道谁在前谁在后
        //因此有了下边的countingSort2
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

    private static void countingSort2(int[] a) {
        if(a==null || a.length < 2) return;

        //先找到max
        int max = Integer.MIN_VALUE;
        for(int i : a){
            max = Math.max(max, i);
        }
        //先用一个counting array计数
        int[] counting = new int[max+1];
        for(int i : a){
            counting[i]++;
        }

        //取得每个元素出现次数的技术数组后，对他们做一个累加和
        for(int i = 1; i < counting.length; i++){
            counting[i] += counting[i-1];
        }
        //这个累加和，便意味着有这么多个数比该数来得小或相等，用这一点便可来进行排序
        //此时从后往前遍历数组,然后把对应的元素放在这个累加和的位置（数组从0开始，因此-1）
        //摆完后，累加和--，又是从后往前遍历，因此下一个一样的会排在他前边
        //由此保证了稳定性
        int[] result = new int[a.length];
        for(int i = a.length-1; i>=0 ; i--){
            result[counting[a[i]]-1] = a[i];
            --counting[a[i]];
        }
        System.arraycopy(result,0,a,0,result.length);
    }
}
