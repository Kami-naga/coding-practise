package basic.linkedList;

public class PrintCommonPartList {
    public static class Node{ //单向链表
        private Integer value;
        private Node next;
        public Node(int v){
            this.value = v;
            this.next = null;
        }

    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(-1);
        Node n7 = new Node(1);
        Node n8 = new Node(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n6.next = n7;
        n7.next = n8;
        n8.next = n4;

       // printCommon(n1, n6);
        printOrderedCommon(n1, n6);
    }

    private static void printCommon(Node n1, Node n2) {
        if(n1 == null || n2 == null) return;
        Node cur = n1;
        Node cur2 = n2;
        int d = 0;
        while(cur != null){
            cur = cur.next;
            d++;
        }
        while(cur2 != null){
            cur2 = cur2.next;
            d--;
        }
        cur = d >= 0 ? n1 : n2;
        cur2 = d >= 0 ? n2 : n1;
        d = Math.abs(d);
        while(d > 0){
            cur = cur.next;
            d--;
        }
        while(cur != null){
            if(cur == cur2){
                System.out.println(cur.value);
            }
            cur = cur.next;
            cur2 = cur2.next;
        }
    }

    private static void printOrderedCommon(Node n1, Node n2) {
        while(n1 != null && n2 != null){
            if(n1.value < n2.value){
                n1 = n1.next;
            }else if(n1.value > n2.value){
                n2 = n2.next;
            }else{
                System.out.println(n1.value);
                n1 = n1.next;
                n2 = n2.next;
            }
        }
    }
}
