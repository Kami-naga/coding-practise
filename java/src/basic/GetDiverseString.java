package basic;

import java.util.PriorityQueue;

public class GetDiverseString {
    public static void main(String[] args) {
        for(int i=0; i< 1000; i++){
            int A = getRandomInput();
            int B = getRandomInput();
            int C = getRandomInput();

            String s= getDiverse(A,B,C);
            if(!checkString(s)){
                System.out.println("something wrong!");
                System.out.println(A+" "+B+" "+C);
                System.out.println(s);
            }
        }
        System.out.println("all clear");
    }

    private static boolean checkString(String s) {
        return !s.contains("aaa") && !s.contains("bbb") && !s.contains("ccc");
    }

    private static int getRandomInput() {
        return (int)(Math.random()* 100);
    }

    public static class Alphabet{
        private int num;
        private String a;
        public Alphabet(int n, String aa){
            this.num = n;
            this.a = aa;
        }
        public void setNum(int n){
            this.num = n;
        }
        public int getNum(){
            return this.num;
        }
    }

    public static String getDiverse(int A, int B, int C){
        PriorityQueue<Alphabet> heap =new PriorityQueue<>((x,y)->(y.num-x.num));
        String res = "";
        String last2 = "e";
        String last1 = "d";
        heap.add(new Alphabet(A, "a"));
        heap.add(new Alphabet(B, "b"));
        heap.add(new Alphabet(C, "c"));

        while(!heap.isEmpty()){
            Alphabet a = heap.poll();
            if(last1.equals(last2) && a.a.equals(last1)){
                if(!heap.isEmpty()){
                    Alphabet b = heap.poll();
                    res += b.a;
                    last2 = last1;
                    last1 = b.a;
                    b.setNum(b.getNum()-1);
                    if(b.getNum()!=0){
                        heap.add(b);
                    }
                }else{
                    return "";
                }
            }else{
                res += a.a;
                last2 = last1;
                last1 = a.a;
                a.setNum(a.getNum()-1);
            }
            if(a.getNum()!=0){
                heap.add(a);
            }
        }
        return res;
    }
}
