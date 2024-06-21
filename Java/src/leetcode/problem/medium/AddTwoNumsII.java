package leetcode.problem.medium;

import leetcode.classes.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddTwoNumsII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        getValuesList(stack1, l1);
        getValuesList(stack2, l2);

        ListNode res = null;
        int carry = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();
            ListNode node = new ListNode(sum%10);
            node.next = res;
            res = node;

            carry = sum / 10;
        }



        return res;
    }

    private void getValuesList(Stack<Integer> stack, ListNode l) {
        while (l != null) {
            stack.add(l.val);
            l = l.next;
        }
    }


    @Test
    public void sampleTest() {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));
    }
}
