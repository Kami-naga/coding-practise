package basic.linkedList;

public class FindFirstIntersectNode {
    //寻找两个单向链表的首个相交节点
    //面试最高难度链表题！
    //思路：
    //单向链表可能有环可能无环，二者相交也可以有多种方式，
    //但需要注意的是，单向链表一旦相交，后边应该都是一致的，不会有两个出口这样的玩意儿
    //所以有以下情况
    //1. 2个无环单向链表相交(Y字形) 可以有
    //2. 一个无环一有环？不可能，这俩要能相交，这俩都应该是有环才是
    //3. 2个都有环 可以有，但这时根据相交的位置又有一些细微差别
    //3.1. 在环之前相交（Y+O）这样的图，就当俩无环相交一样解就好了
    //3.2  在环部分相交(O上边长两个角)，这时候让一个转圈走找另一个！

    public static class Node{
        public int value;
        public Node next;

        public Node(int v){ value = v;}
    }

    public static void main(String[] args) {
// 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }

    private static Node getIntersectNode(Node head1, Node head2) {
        if(head1 == null || head2 == null) return null;
        Node loopStart1 = haveLoop(head1);
        Node loopStart2 = haveLoop(head2);
        if(loopStart1 == null && loopStart2 == null){
            return twoLinear(head1, head2, null);
        }
        if(loopStart1 != null && loopStart2 != null){
            if(loopStart1 == loopStart2){
                return twoLinear(head1, head2, loopStart1);
            }else{
                return inLoop(loopStart1, loopStart2);
            }
        }
        return null;
    }

    private static Node inLoop(Node loopStart1, Node loopStart2) {
        Node cur = loopStart1.next;
        while(cur != loopStart1){
            if(cur == loopStart2){
                return loopStart1;
            }
            cur = cur.next;
        }
        return null;
    }

    private static Node twoLinear(Node head1, Node head2, Node endNode) {
        Node cur = head1;
        int d = 0;
        while(cur != endNode){
            ++d;
            cur = cur.next;
        }
        cur = head2;
        while(cur != endNode){
            --d;
            cur = cur.next;
        }
        cur = d > 0 ? head1 : head2;
        Node cur2 = d > 0 ? head2 : head1;
        d = Math.abs(d); //别忘了取绝对值！
        while(d > 0){
            cur = cur.next;
            --d;
        }
        while(cur != endNode && cur2 != endNode){
            if(cur == cur2){
                return cur;
            }
            cur = cur.next;
            cur2 = cur2.next;
        }
        return cur == cur2 ? cur : null;
    }

    private static Node haveLoop(Node head) {
        //既然后边会需要这个入环节点，那么不如检测是否成环时就返回入环节点，通过是否为null判断是否成环
        if(head == null || head.next == null) return null;
        //快慢指针的设置，讲究点或许应当整一个dummy node，
        //大家都从第一个节点开始走，但这里大家都偏移一个1，从head开始走不影响结果的
        Node fast = head.next.next;
        Node slow = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
//        while(fast != null && fast.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if(slow == fast){
//                fast = dummy;
//                while(fast != slow){
//                    fast = fast.next;
//                    slow = slow.next;
//                }
//                return slow;
//            }
//        }
    }

}
