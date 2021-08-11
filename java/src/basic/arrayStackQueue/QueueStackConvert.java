package basic.arrayStackQueue;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueStackConvert {

    public static class Queue2Stack {
//2个queue倒来倒去留一个下来pop这样就好了
        private Queue<Integer> q1;
        private Queue<Integer> q2;

        public Queue2Stack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int v) {
            q1.offer(v);
        }

        public Integer pop() {
            if (q1.isEmpty()) {
                throw new RuntimeException("nothing to pop!");
            }
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            int res = q1.poll();
            swap();
            return res;
        }

        public Integer peek() {
            if (q1.isEmpty()) {
                throw new RuntimeException("nothing to pop!");
            }
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            int res = q1.poll();
            q2.offer(res);
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp;
            tmp = q2;
            q2 = q1;
            q1 = tmp;
        }
    }
    public static class Stack2Queue{
//2个stack，朝入stack加数据和从出stack取数据两者是互相独立的，所以可以一个入一个出
//只是从入stack倒到出stack的时候需要注意两点：
//1. 倒的时候得一次全部倒干净
//2. 出stack里有东西，那么入stack不准倒
        private Deque<Integer> s1;
        private Deque<Integer> s2;

        public Stack2Queue(){
            s1 = new LinkedList<>();
            s2 = new LinkedList<>();
        }

        public void push(int v){

//                while(!s2.isEmpty()){
//                    s1.push(s2.pop());
//                }
            s1.push(v);
        }

        public Integer pop(){
            if(s1.isEmpty() && s2.isEmpty()){
                throw new RuntimeException("nothing to pop!");
            }else if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public Integer peek(){
            if(s1.isEmpty() && s2.isEmpty()){
                throw new RuntimeException("Queue is empty!");
            }else if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }
    }



    public static void main(String[] args) {
        Queue2Stack stack = new Queue2Stack();
        stack.push(3);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        Stack2Queue queue = new Stack2Queue();
        queue.push(3);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
