package jack.reverse;

/**
 * 链表局部反转
 */
public class ListReverse2 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (m >= n || head == null || head.next == null) {
            return head;
        }
        // 头插法
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        // i用来记录移动到第几个节点
        int i = 0;
        while (cur != null && i < m - 1) {
            pre = pre.next;
            cur = cur.next;
            i++;
        }
        // 将cur右边的 m - n 个节点插入到头节点
        i = 0;
        while (cur != null && i < n - m) {
            // 删除节点
            ListNode node = cur.next;
            cur.next = cur.next.next;
            // 将该节点添加到头指针后边
            node.next = pre.next;
            pre.next = node;
            i++;
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
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node1.next = node2;
        node2.next = null;
        node1 = reverseBetween(node1, 1, 2);
        printList(node1);
    }
}
