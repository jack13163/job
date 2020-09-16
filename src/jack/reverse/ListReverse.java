package jack.reverse;

/**
 * 链表反转
 */
public class ListReverse {

    static class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        // 计算需要反转的次数
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        int rCount = count / k;

        // 利用头插法，逐步反转
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        cur = head;
        ListNode temp;// 要删除的元素
        for (int i = 0; i < rCount; i++) {
            for (int j = 1; j < k; j++) {
                // 删除节点
                temp = cur.next;
                cur.next = temp.next;
                // 添加到头节点后面
                temp.next = pre.next;// cur和pre.next不同，因为temp指针不会动，每次删除和添加的都是cur指针的下一个节点
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }

    // 输出链表
    public static void printList(ListNode head) {
        ListNode cur = head;
        do {
            System.out.print(cur.val + " ");
            cur = cur.next;
        } while (cur != null);
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode();
        list1.val = 9;
        ListNode node2 = new ListNode();
        list1.next = node2;
        node2.val = 3;
        ListNode node3 = new ListNode();
        node2.next = node3;
        node3.val = 7;
        node3.next = null;

        ListNode reversed = reverseKGroup(list1, 2);
        printList(reversed);
    }
}
