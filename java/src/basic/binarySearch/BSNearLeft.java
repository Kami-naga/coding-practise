package basic.binarySearch;

public class BSNearLeft {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,5,5,6,7,8,8,9,9,10};
        System.out.println(bsNearLeft(a, 10));
    }

    private static int bsNearLeft(int[] a, int k) {
        if(a == null) return -1;
        if(a.length < 2) return a[0] == k ? 0 : -1;

        int L = 0;
        int R = a.length - 1;
        int index = -1;
        int index2 = -1;
        while(L <= R){
            int M = L + ((R - L) >> 1);
            if(a[M] >= k){ //缩右界，记录相等下标，最后得到最左值
                R = M - 1;
                index = M;
            }else{
                L = M + 1;
                index2 = M;
            }
            // 同理若缩左界，记录相等下标，最后可得最右值
//            if(a[M] <= k){
//                L = M + 1;
//                index = M;
//            }else{
//                R = M - 1;
//            }
        }
        System.out.println(index2); //index2 + 1好像也彳亍
        return index;
    }


}
