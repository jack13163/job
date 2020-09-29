package job.jack.list;

/**
 * 单链表选择排序
 */
public class SortList {

    /**
     * 链表节点
     */
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
    }

    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public static ListNode sortInList(ListNode head) {
        // 寻找最小的元素，并利用头插法插入到节点
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode sorted = dummy;

        while (sorted.next != null) {
            ListNode pre = sorted;
            ListNode cur = sorted.next;
            ListNode pre_min = null;
            ListNode min = null;

            // 寻找最小的数
            while (cur != null) {
                if (min == null || cur.val < min.val) {
                    min = cur;
                    pre_min = pre;
                }
                // 继续向后移动指针
                cur = cur.next;
                pre = pre.next;
            }

            // 利用头插法插入
            pre_min.next = min.next;
            min.next = sorted.next;
            sorted.next = min;

            // 哨兵节点往后移动
            sorted = min;
        }

        return dummy.next;
    }

    /**
     * 输出单链表
     * @param head
     */
    public static void printList(ListNode head){
        ListNode cur = head;

        // 寻找最小的数
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            // 继续向后移动指针
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode list1 = new ListNode(2);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(5);
        list1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode head = sortInList(list1);
        printList(head);
    }
}
