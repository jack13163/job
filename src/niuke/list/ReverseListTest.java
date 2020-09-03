package niuke.list;

public class ReverseListTest {
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


        ListNode list2 = new ListNode();
        list2.val = 6;
        ListNode node4 = new ListNode();
        list2.next = node4;
        node4.val = 3;
        node4.next = null;

        printList(list1);
        printList(list2);

        ListNode reversedList1 = reverse(list1);
        ListNode reversedList2 = reverse(list2);

        printList(reversedList1);
        printList(reversedList2);

        // 遍历反转后的list
        ListNode p3 = reversedList1;
        ListNode p4 = reversedList2;
        ListNode resutList = null;// 结果列表
        int forward = 0;
        while (p3 != null || p4 != null) {
            int sum = 0;
            if(p3 != null){
                sum += p3.val;
            }

            if(p4 != null){
                sum += p4.val;
            }
            sum += forward;

            // 当前位值
            int val = sum % 10;
            // 进位
            forward = sum / 10;

            // 生成结果链表
            if (resutList == null){
                resutList = new ListNode(val);
            }else{
                // 利用双指针法找到倒数第一个元素
                ListNode lastNode = getLastNode(resutList);
                lastNode.next = new ListNode(val);
            }

            // 指针向下移动
            if(p3 != null){
                p3 = p3.next;
            }
            if(p4 != null) {
                p4 = p4.next;
            }
        }

        if(forward > 0){
            ListNode lastNode = getLastNode(resutList);
            lastNode.next = new ListNode(forward);
        }


        System.out.println("--------------------------------结果--------------------------------");
        resutList = reverse(resutList);
        printList(resutList);
    }

    /**
     * 利用双指针法找到倒数第一个元素
     * @param resutList
     * @return
     */
    private static ListNode getLastNode(ListNode resutList) {
        ListNode p5 = resutList;// 结果列表指针
        ListNode p6 = resutList.next;// 结果列表指针
        while(p6 != null){
            p5 = p5.next;
            p6 = p6.next;
        }
        return p5;
    }

    // 链表反转
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 输出链表
    public static void printList(ListNode head) {
        ListNode cur = head;
        do {
            System.out.print(cur.val + " ");
            cur = cur.next;
        } while(cur != null);
        System.out.println();
    }

}
