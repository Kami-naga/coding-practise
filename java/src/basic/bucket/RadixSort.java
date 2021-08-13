package basic.bucket;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] a = new int[]{30,18,55,83,2,78,632,9,44,2,71};
        radixSort(a);
        for(int i : a){
            System.out.print(i+" ");
        }
    }

    private static void radixSort(int[] a) {
        //基数排序和计数排序其实差不多，只是基数排序是每一位（个十百千...）做一次计数排序
        if(a == null || a.length < 2) return;

        //老样子先找max，通过max确定最大位数，由此知道做几轮
        int max = Integer.MIN_VALUE;
        for(int i : a){
            max = Math.max(i, max);
        }
        int times = getDigits(max);
        //创建计数数组
        final int radix = 10; //0~9十个数字
        int[] counting = new int[radix];

        int[] result = new int[a.length];
        //开始每一位进行计数&排序
        for(int i = 1 ; i <= times; i++){
            //对应位数进行计数
            for (int value : a) {
                counting[getDigit(value, i)]++;
            }
            //累加和
            for(int k = 1; k < counting.length; k++){
                counting[k] += counting[k-1];
            }
            //利用累加和在result数组中从后向前对该应位数进行排序
            for(int m = result.length-1; m >= 0; m--){
                int d = getDigit(a[m], i);
                result[counting[d]-1] = a[m];
                --counting[d];
            }

            //排完后，更新a的排序
            System.arraycopy(result,0,a,0,result.length);
            //counting记得清零~
            Arrays.fill(counting, 0);
        }

    }

    private static int getDigit(int num, int d) {
        return (num / (int)Math.pow(10, d-1)) %10;
    }

    private static int getDigits(int num) {
        int digits = 1;
        while(num/10 != 0){
            digits++;
            num /= 10;
        }
        return digits;
    }
}
