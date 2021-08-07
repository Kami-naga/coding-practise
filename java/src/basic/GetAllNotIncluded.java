package basic;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllNotIncluded {
    public static void main(String[] args) {
        int[] sorted = new int[]{1, 3, 5, 7, 9};
        int[] unsorted = new int[]{7, 9, 2, 5, 1, 4,10,11};
        solution1(sorted, unsorted);
        System.out.println();
        System.out.println("sol 2");
        for(int i:  solution2(sorted, unsorted)){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("sol 3");
        for(int i:  solution3(sorted, unsorted)){
            System.out.print(i+" ");
        }
    }

    public static void solution1(int[] sorted, int[] unsorted) { //O(MxN)
        for(int i : unsorted) {
            boolean flag = true;
            for(int j : sorted){
                if (i == j){
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.print(i+ " ");
            }
        }
    }

    public static ArrayList<Integer> solution2(int[] sorted, int[] unsorted) {
        //O(MlogN), N large, this one better
        ArrayList<Integer> result = new ArrayList<>();
        for(int i: unsorted){
            int L = 0;
            int R = sorted.length - 1;
            boolean contains = false;
            while(L <= R){
                int M = L + ((R - L) >> 1);
                if(sorted[M] == i){
                    contains = true;
                    break;
                }else if(sorted[M] < i){
                    L = M + 1;
                }else{
                    R = M - 1;
                }
            }
            if (!contains){
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> solution3(int[] sorted, int[] unsorted) {
        //O(MlogM)+O(N+M), M large, this one better
        Arrays.sort(unsorted);
        int n = 0, m = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(n < sorted.length && m < unsorted.length){
            if(sorted[n] == unsorted[m]){
                n++;
                m++;
            }else if(sorted[n] < unsorted[m]){
                n++;
            }else{
                result.add(unsorted[m]);
                m++;
            }
        }
        if(m != unsorted.length){
            for(int i = m;i<unsorted.length;i++){
                result.add(unsorted[i]);
            }
        }
        return result;
    }
}
