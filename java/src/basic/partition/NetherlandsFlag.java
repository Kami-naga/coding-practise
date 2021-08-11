package basic.partition;

public class NetherlandsFlag {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,8,2,7,6,9,4,2,7};
        int num = 5;
        netherlandsFlag(a, 0, a.length-1, num);
        for(int i : a){
            System.out.print(i+" ");
        }
    }

    private static void netherlandsFlag(int[] a, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while(cur < more){
            if(a[cur] < num){
                swap(a, ++less, cur++);
            }else if(a[cur] > num){
                swap(a, --more, cur);
            }else{
                cur++;
            }
        }
        //中间相等区域区间就是[less+1, more-1],若没有区间会为一个错误区间，如[2,1],因此可用L<R来辨别是否有等于区域
    }

    private static void swap(int[] a, int m, int n) {
        if(a[m] == a[n]) return;
        a[m] = a[m]^a[n];
        a[n] = a[m]^a[n];
        a[m] = a[m]^a[n];
    }


}
