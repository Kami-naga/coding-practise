package basic.linkedList;

public class ReverseLinkedList {

    public static class Node{ //单向链表
        private Integer value;
        private Node next;

        public Node(int v){
            this.value = v;
            this.next = null;
        }
    }

    public static class Node2{ //双向链表
        private Integer value;
        private Node2 next;
        private Node2 prev;
        public Node2(int v){
            this.value = v;
            this.next = null;
            this.prev = null;
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        reverseLinkedList(n1);

        while(n5 != null){
            System.out.println(n5.value);
            n5 = n5.next;
        }

        Node2 n11 = new Node2(1);
        Node2 n22 = new Node2(2);
        Node2 n33 = new Node2(3);
        Node2 n44 = new Node2(4);
        Node2 n55 = new Node2(5);

        n11.next = n22;
        n22.next = n33;
        n33.next = n44;
        n44.next = n55;

        n22.prev = n11;
        n33.prev = n22;
        n44.prev = n33;
        n55.prev = n44;

        reverseLinkedList2(n11);

        while(n55 != null){
            System.out.println(n55.value);
            n55 = n55.next;
        }
    }

    private static void reverseLinkedList(Node n) {
        Node prev = null;
        Node next;
        Node cur = n;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }

    private static void reverseLinkedList2(Node2 n) {
        Node2 prev = null;
        Node2 next;
        Node2 cur = n;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            cur.prev = next;
            prev = cur;
            cur = next;
        }
    }
}
