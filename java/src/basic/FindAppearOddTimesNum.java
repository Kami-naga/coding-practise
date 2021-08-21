package basic;

import java.util.Arrays;

//一个数组，里头有一个只出现奇数次的数，其他数都出现偶数次，如何得到那个只出现奇数次的数
//进阶:如果只出现奇数次的数有俩，那俩数又该如何取得
public class FindAppearOddTimesNum {
    public static void main(String[] args) {
        int[] a = new int[]{3,8,1,5,8,2,7,5,6,9,3,6,9,4,2,7,1};
        System.out.println(findTheOnlyOdd(a));
        int[] b = new int[]{3,8,1,5,8,2,7,5,6,9,7,3,6,9,4,2,7,1};
        System.out.println(Arrays.toString(findTwoOdd(b)));
    }

    private static int[] findTwoOdd(int[] a) {
        int eor = 0;
        // get a ^ b
        for(int i : a){
            eor ^= i;
        }
        //a ^ b,两个不同的数相异或，其二进制结果至少含有一个1
        //通过这个1，来区分a和b，假设a有1，b无1，
        //原数组中只异或含1的一组，即可把不含1的另一个b剔除得到含1的a，
        //这样就得到结果了
        int rightOne = eor & (~eor + 1); //得到其最右侧的1，其余位全为0
        int eor2 = 0;
        for(int i : a){
            if((i & rightOne) != 0){
                eor2 ^= i;
            }
        }
        return new int[]{eor2, eor ^ eor2};
    }

    private static int findTheOnlyOdd(int[] a) {
        int eor = 0;
        for(int i : a){
            eor ^= i;
        }
        return eor;
    }
}
