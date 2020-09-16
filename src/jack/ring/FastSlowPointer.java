package jack.ring;

import jack.list.DeleteDuItems;

import java.util.HashMap;
import java.util.Map;

/**
 * 利用快慢指针法求最大的距离
 */
public class FastSlowPointer {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 检测环
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // 利用快慢指针进行搜索环的入口
        ListNode fast = head;
        ListNode slow = head;

        // 遍历，找到相撞位置
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }

        // 两个指针相撞，代表存在环
        if (fast == slow) {
            // 慢指针从头开始移动，快指针从相撞位置移动
            slow = head;
            // 快慢指针以相同的速度移动，若再次相撞，则代表为入口
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }else{
            return null;
        }
    }

    /**
     * 创建链表
     *
     * @return
     */
    public static ListNode createList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = null;
        return node1;
    }

    public static void main(String[] args) {
        ListNode root = createList();
        System.out.println(detectCycle(root));
    }
}
