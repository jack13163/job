package jack.list;

import java.util.Stack;


public class AddList {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> res = new Stack<>();// 结果栈
        ListNode p1 = head1;
        ListNode p2 = head2;
        // 操作数1入栈
        while (p1 != null) {
            stack1.add(p1.val);
            p1 = p1.next;
        }
        // 操作数2入栈
        while (p2 != null) {
            stack2.add(p2.val);
            p2 = p2.next;
        }
        // 计算结果，并入栈
        int jw = 0;
        int yu = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int num1 = stack1.pop();
            int num2 = stack2.pop();
            int sum = num1 + num2 + jw;
            jw = sum / 10;
            yu = sum % 10;
            // 如果结果栈不为空，则进位加1
            res.add(yu);
        }

        while (!stack1.isEmpty()) {
            int sum = jw + stack1.pop();
            jw = sum / 10;
            yu = sum % 10;
            res.add(yu);
        }

        while (!stack2.isEmpty()) {
            int sum = jw + stack2.pop();
            jw = sum / 10;
            yu = sum % 10;
            res.add(yu);
        }

        if (jw > 0) {
            res.add(jw);
        }
        // 生成结果链表
        if (!res.isEmpty()) {
            ListNode root = new ListNode(res.pop());
            ListNode pre = root;
            while (!res.isEmpty()) {
                ListNode cur = new ListNode(res.pop());
                pre.next = cur;
                pre = cur;
            }
            pre.next = null;
            return root;
        } else {
            return null;
        }
    }

    /**
     * 创建链表
     *
     * @param str
     * @return
     */
    public static ListNode createList(String str) {
        String tmp = str.substring(1, str.length() - 1);
        String[] res = tmp.split(",");

        if (res.length > 0) {
            ListNode root = new ListNode(Integer.parseInt(res[0]));
            ListNode pre = root;
            for (int i = 1; i < res.length; i++) {
                ListNode cur = new ListNode(Integer.parseInt(res[i]));
                pre.next = cur;
                pre = cur;
            }
            pre.next = null;
            return root;
        } else {
            return null;
        }
    }

    // 输出链表
    public static void printList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode cur = head;
        do {
            System.out.print(cur.val + " ");
            cur = cur.next;
        } while (cur != null);
        System.out.println();
    }


    public static void main(String[] args) {
        // [9,3,7],[6,3]
        ListNode list1 = createList("[9,3,7,9]");
        ListNode list2 = createList("[6,3]");
        ListNode res = addInList(list1, list2);
        printList(res);
    }
}
