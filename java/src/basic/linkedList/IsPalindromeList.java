package basic.linkedList;

import java.util.Deque;
import java.util.LinkedList;

public class IsPalindromeList {


    private static boolean isPalindrome3(Node head) {
        //extra space complexity O(1)
        //后半部分反转链表，然后一个个比对
        //最后再把链表还原
        if(head == null || head.next == null) return true;  //只有一个节点亦可直接返回true
        boolean isPalindrome = true;
        Node fast = head.next;
        Node slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node cur = slow.next;
        slow.next = null;
        Node rHead = reverseList(cur);
        Node rCur = rHead;
        cur = head;
        while(rCur != null && cur != null){
            if(rCur.value != cur.value){
                isPalindrome = false;
                break;
            }
            rCur = rCur.next;
            cur = cur.next;
        }
        slow.next = reverseList(rHead);
        return isPalindrome;
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node next;
        Node cur = head;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static boolean isPalindrome2(Node head) {
        //快慢指针找到中点+后半部分用stack记录再比对
        if (head == null || head.next == null) return true;
        Node fast = head.next;
        Node slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Deque<Integer> stack = new LinkedList<>();
        Node cur = slow.next;
        while(cur != null){
            stack.push(cur.value);
            cur = cur.next;
        }
        cur = head;
        while(!stack.isEmpty()){
            if(cur.value != stack.pop()){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    private static boolean isPalindrome1(Node head) {
        //笔试时写法，使用额外空间解决，此处用个stack
        if (head == null || head.next == null) return true;
        Deque<Integer> stack = new LinkedList<>();
        Node cur = head;
        while(cur != null){
            stack.push(cur.value);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            if(cur.value != stack.pop()){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    private static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        isPalindrome3(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");
    }
}
