package basic.arrayStackQueue;

public class ArrayToStackAndQueue {

    public static class ArrayStack{
//注意push和pop时对index的操作哦，就size的大小，
//push时候是index++用到[0]，但pop和peek的时候得--index&index-1
        private int index;
        private Integer[] a;

        public ArrayStack(int size){
            if(size < 0){
                throw new IllegalArgumentException("size must bigger than 0!");
            }
            index = 0;
            a = new Integer[size];
        }

        public void push(int v){
            if(index == a.length){
                throw new ArrayIndexOutOfBoundsException("array is full!");
            }
            a[index++] = v;
        }

        public Integer pop(){
            if(index == 0){
                throw new RuntimeException("no elements in array now");
            }
            return a[--index];
        }

        public Integer peek(){
            if(index == 0){
                return null;
            }
            return a[index-1];
        }
    }

    public static class ArrayQueue{
//用first和last分别指向queue的头和尾，
//然后多引入一个size来对其大小来进行约束，而非仅靠头尾指针，否则写起来就复杂了，容易错
        private Integer[] a;
        private Integer first;
        private Integer last;
        private Integer size;

        public ArrayQueue(int size){
            if(size < 0){
                throw new IllegalArgumentException("size must bigger than 0!");
            }
            a = new Integer[size];
            last = 0;
            first = 0;
            this.size = 0;
        }

        public void push(Integer v){
            if(size == a.length){
                throw new RuntimeException("array is full");
            }
            a[last] = v;
            last = last == a.length - 1 ? 0: last +1;
            size++;
        }

        public Integer pop(){
            if(size == 0){
                throw new RuntimeException("nothing to pop");
            }
            size--;
            int ret = first;
            first = first == a.length - 1 ? 0: first +1;
            return a[ret];
        }

        public Integer peek(){
            if(size == 0){
                return null;
            }
            return a[first];
        }
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        ArrayQueue queue = new ArrayQueue(3);
        queue.push(3);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
