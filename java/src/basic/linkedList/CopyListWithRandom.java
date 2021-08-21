package basic.linkedList;

import java.util.HashMap;

public class CopyListWithRandom {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;
        public Node(int data) {
            this.value = data;
        }
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1;
        Node res2;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");
    }

    private static Node copyListWithRand2(Node head) {
        //不额外使用空间，那该如何创建map这种一一对应关系呢？
        //让原先链表每个节点后跟上他的复制节点，由此一一对应
        //最后复原整个链表就ok了
        if(head == null) return null;
        Node cur = head;
        while(cur != null){
            Node copy = new Node(cur.value);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        cur = head;
        Node copyHead = head.next;
        while(cur != null){
            cur.next.rand = cur.rand != null ?cur.rand.next: null;
            cur = cur.next.next;
        }
        cur = head;
        while(cur != null){
            Node copy = cur.next;
            cur.next = copy.next;
            copy.next = cur.next != null ? cur.next.next: null;
            cur = cur.next;
        }
        return copyHead;
    }

    private static Node copyListWithRand1(Node head) {
        if(head == null) return null;
        //使用hash map额外空间来创建&储存复制节点
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

}
