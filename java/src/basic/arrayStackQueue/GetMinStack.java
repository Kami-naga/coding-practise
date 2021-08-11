package basic.arrayStackQueue;

import java.util.Deque;
import java.util.LinkedList;

public class GetMinStack {
    private Deque<Integer> data;
    private Deque<Integer> min;

    public GetMinStack(){
        data = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int v){
        if(min.isEmpty()){
            min.push(v);
        }else if(this.getMin() < v){
            min.push(min.peek());
        }else{
            min.push(v);
        }
        data.push(v);
    }

    public Integer peek(){
        if(data.isEmpty()){
            return null;
        }
        return data.peek();
    }

    public Integer pop(){
        if(data.isEmpty()){
            throw new RuntimeException("stack is empty!");
        }
        min.pop();
        return data.pop();
    }

    public Integer getMin(){
        if(data.isEmpty()){
            throw new RuntimeException("stack is empty!");
        }
        return min.peek();
    }

    public static void main(String[] args) {
        GetMinStack stack2 = new GetMinStack();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }
}
