package basic.binarySearch;

public class FindOneLessValue {
    public static void main(String[] args) {
        int[] a = new int[]{9,7,3,4,5,7,8,9,11};
        System.out.println(findLess(a, 0, a.length-1));
    }

    private static int findLess(int[] a, int left, int right) {
        if(a == null || a.length < 2) return -1;
        //找其中一个局部极小值点怎么找呢（并非该域上的最小值）
        //1. 边界点
        if(a[left] < a[left + 1]) return a[left];
        if(a[right] < a[right - 1]) return a[right];

        //2. 数组当中某个极小值点
        int L = left + 1;
        int R = right - 1;
        while(L < R){
            int M = L + ((R - L) >> 1);
            if(a[M] > a[M - 1]){
                //看是否递增，是的话，右界左缩接着找
                R = M - 1;
            }else if(a[M] > a[M + 1]){
                //看是否递减，是的话，左界右缩接着找
                L = M + 1;
            }else{ //说明M这个位置是凹下去的一个点(左比它大，右也比它大)，所以返回m位置的值
                return a[M];
            }
        }
        //经过上边操作，L和R来到了同一个位置，这位置的数就是极值了
        return a[L];

    }

}
