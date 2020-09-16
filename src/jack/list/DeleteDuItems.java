package jack.list;

import niuke.list.ListNode;

/**
 * 删除链表重复元素
 */
public class DeleteDuItems {
    static class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // 特殊情況處理
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        // write code here
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = head.next;
        boolean flag = false;
        while (next != null) {
            if (cur.val == next.val) {
                flag = true;//標記要刪除了，但是向後搜索，一次性找到所有
                next = next.next;
            }

            if (flag && (next == null || cur.val != next.val)) {
                // 刪除
                pre.next = next;
                cur = next;
                if(next != null) {
                    next = next.next;
                }
                flag = false;// 標記刪除完成
            } else if(cur.val != next.val) {
                pre = pre.next;
                cur = cur.next;
                next = next.next;
            }
        }
        return dummy.next;
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
        ListNode list1 = new ListNode();
        list1.val = 1;
        ListNode node2 = new ListNode();
        list1.next = node2;
        node2.val = 1;
        ListNode node3 = new ListNode();
        node2.next = node3;
        node3.val = 1;
        node3.next = null;

        ListNode reversed = deleteDuplicates(list1);
        printList(reversed);
    }
}
