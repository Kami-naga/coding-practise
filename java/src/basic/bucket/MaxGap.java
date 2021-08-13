package basic.bucket;

//给一个无序数组，求排序后数组中相邻2数最大的间距，要求时间复杂度O(n)
public class MaxGap {

    public static void main(String[] args) {
        int[] a = new int[]{30,18,55,83,2,78,632,9,44,2,71};
        System.out.println(maxGap(a));
    }

    private static int maxGap(int[] a) {
        //利用桶的思路来解
        //先拿到max和min，对n个数，min放0桶，max放最后一个桶，
        //然后分配总共n+1个桶（两端桶不空，多一个桶，那么其中必有一个桶为空桶）
        //数组排序分配进桶之后，相邻两数要么来自同一个桶，要么来自不同的桶
        //空桶的存在说明相邻间隔最大的两数肯定来自不同的桶
        //因为空桶占了一个分配区间，因此空桶两侧的非空桶的间隔必大于这个分配区间的值
        //所以间距最大的必来自两个桶，遍历有值的前桶最大值和有值的后桶最小值差值，便可找到最大间距
        //那么这两个桶一定是空桶两侧的两个桶吗?
        //这可未必，举个例子，
        //每个区间大小为10，0~9中有个9，后边10~19是空桶，再后面20~29有个20,此时他们间隔11
        //然后后边再有个相邻桶30~39中有个39，20到39间隔19，
        //所以空桶周围未必有最大间隔，还是得一个个看

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i : a){
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        //max和min相等说明数组中所有数都一样，所以间距为0
        if(max == min) return 0;

        int len = a.length;
        //每个桶只需记录桶中最大最小值和是否有值就好了
        int[] minNums = new int[len+1];
        int[] maxNums = new int[len+1];
        boolean[] notEmpty = new boolean[len+1];

        for (int num : a) {
            int bid = getBID(num, len, min, max); //得到该数所在桶的编号（通过比例求得:len*(num-min)/(max-min)）
            minNums[bid] = notEmpty[bid] ? Math.min(num, minNums[bid]) : num;
            maxNums[bid] = notEmpty[bid] ? Math.max(num, maxNums[bid]) : num;
            notEmpty[bid] = true;
        }

        int maxGap = 0;
        int lastMax = maxNums[0];
        for(int i = 1;i < len + 1;i++){
            if(notEmpty[i]){ //对每个非空桶，计算该桶最小值和上一个有东西的桶的最大值的差值，maxGap就在其中
                maxGap = Math.max(maxGap,minNums[i]-lastMax);
                lastMax = maxNums[i];
            }
        }
        return maxGap;
    }

    private static int getBID(int num, int len, int min, int max) {
        return (num-min)*len/(max-min); //此处*len得写在前边，写到后边则会导致先整除操作得到一个0，再乘以len还是0，所以len写到前边去，乘了len再整除
    }
}
