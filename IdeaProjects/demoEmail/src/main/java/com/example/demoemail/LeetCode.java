package com.example.demoemail;

import java.util.LinkedList;
import java.util.List;

public class LeetCode {
    private static long getNumberFromList(ListNode list) {
        long rs = 0;
        int pow = 0;
        while (list != null) {
            rs += (long) (Math.pow(10.0, (double) pow) * list.val);
            pow++;
            if (list.next != null) {
                list = list.next;
            } else break;
        }
        return rs;
    }

    private static ListNode getList(long number) {
        ListNode rs = new ListNode();
        ListNode currentNode = rs;
        while (number != 0) {
            currentNode.next = new ListNode((int) number % 10);
            number /= 10;
            currentNode = currentNode.next;
        }
        return rs;
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return getList(getNumberFromList(l1) + getNumberFromList(l2));
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(4);
        ListNode list3 = new ListNode(3);
        list1.next = list2;
        list2.next = list3;

        ListNode list4 = new ListNode(5);
        ListNode list5 = new ListNode(6);
        ListNode list6 = new ListNode(4);
        list4.next = list5;
        list5.next = list6;
//        System.out.println(getNumberFromList(list1));
//        System.out.println(getList(798));
        System.out.println(getNumberFromList(list1));
        System.out.println(getNumberFromList(list4));
        System.out.println(addTwoNumbers(list1, list2));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
