package basic;

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
