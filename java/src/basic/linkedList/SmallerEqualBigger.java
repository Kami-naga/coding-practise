package basic.linkedList;

public class SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
//        printLinkedList(head1);
//        head1 = listPartition1(head1, 1);
        printLinkedList(head1);
        head1 = listPartition2(head1, 0);
        printLinkedList(head1);
    }

    private static Node listPartition1(Node head, int k) {
        //链表塞数组，数组使用partition分为小等大三块再连起来（此法无稳定性）
        if(head == null) return null;
        int i = 0;
        Node cur = head;
        while(cur != null){
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];

        cur = head;
        i = 0;
        while(cur != null){
            nodeArr[i++] = cur;
            cur = cur.next;
        }
        nodeArrPartition(nodeArr, k);
        for(i = 1; i < nodeArr.length; i++){
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[i-1].next = null;
        return nodeArr[0];
    }

    private static void nodeArrPartition(Node[] nodeArr, int k) {
        int less = -1;
        int more = nodeArr.length;
        int cur = 0;
        while(cur < more){
            if(nodeArr[cur].value < k){
                swap(nodeArr, ++less, cur++);
            }else if(nodeArr[cur].value > k){
                swap(nodeArr, --more, cur);
            }else{
                cur++;
            }
        }
    }

    private static void swap(Node[] nodeArr, int i, int j) {
        Node tmp;
        tmp = nodeArr[i];
        nodeArr[i] = nodeArr[j];
        nodeArr[j] = tmp;
    }

    private static Node listPartition2(Node head, int k) {
        //6个指针分别指向小，等，大三块的头尾，遍历原链表，建仨小链表，最后串起来，此法保证稳定性
        if(head == null) return null;
        Node sH = null;
        Node sE = null;
        Node eH = null;
        Node eE = null;
        Node bH = null;
        Node bE = null;
        Node cur = head;
        Node next;
        while(cur != null){
            //每一步把node拆出来，更清晰(next设为null，避免不小心留下原链乱跳，
            //虽然就这题没啥关系，中间next都会被设置，就最后让尾巴的next指向null就ok了
            next = cur.next;
            cur.next = null;

            if(cur.value > k){
                if(bH == null){
                    bH = cur;
                    bE = cur;
                }else{
                    bE.next = cur;
                    bE = cur;
                }
            }else if(cur.value < k){
                if(sH == null){
                    sH = cur;
                    sE = cur;
                }else{
                    sE.next = cur;
                    sE = cur;
                }
            }else{
                if(eH == null){
                    eH = cur;
                    eE = cur;
                }else{
                    eE.next = cur;
                    eE = cur;
                }
            }
            cur = next;
        }

        cur = null;
        if(sE != null){
            cur = sH;
            sE.next = eH != null ? eH : bH;
        }
        if(eH != null){
            cur = cur == null ? eH : cur;
            eE.next = bH;
        }
        cur = cur == null ? bH : cur;
        //bE.next = null;
        return cur;
    }
}
