package basic.heap;

import java.util.PriorityQueue;
//数据流实时获取中位数
public class GetMedian {
    static PriorityQueue<Integer> big = new PriorityQueue<>((x,y)-> (y-x));
    static PriorityQueue<Integer> small = new PriorityQueue<>(); //Comparator.comparingInt(x -> x)

    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,8,2,7,6,9,4,2,7};

        for(int i : a){
            System.out.println(getMedian(i));
        }
    }

    private static double getMedian(int num) {
        if(big.isEmpty()){
            big.add(num);
        }else{
            if(num <= big.peek()){
                big.add(num);
            }else{
                small.add(num);
            }

            if(big.size() > small.size() + 1){
                small.add(big.poll());
            }else if(small.size() > big.size() + 1){
                big.add(small.poll());
            }
        }

        if(big.size() + 1 == small.size()){
            return small.peek();
        }else if(small.size() + 1 == big.size()){
            return big.peek();
        }else{
            return (big.element()+small.element())/2.0;
        }
    }
}
