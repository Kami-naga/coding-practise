package basic;

//使用递归
//时间复杂度怎么看？
//对于子过程规模一致的递归：T(n) = aT(n/b)+O(n^d)
//不一致的不行,如T(N)=T(N/5)+T(2/3N)+O(N^2)
//还有后边如果不是O(n^d)而是诸如O(NlogN)时计算方式也不同，此时要用数学渐进的方式去算
//可使用master公式
//log(b,a) > d -> O(N^log(b,a))
//log(b,a) = d -> O(N^d*logN)
//log(b,a) < d -> O(N^d)

public class GetMax {
    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,8,2,7,6,9,4,2,7};
        System.out.println(getMax(a, 0, a.length - 1));
    }

    private static int getMax(int[] a, int left, int right) {
        if(left == right){
            return a[left];
        }
        int mid = left + ((right - left)>>1);
        int maxLeft = getMax(a, left, mid);
        int maxRight = getMax(a, mid + 1, right);
        return Math.max(maxLeft, maxRight);
    }

}
