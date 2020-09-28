package job.jack.ring;

/**
 * 单向环形链表
 */
public class RingList {

    static class Ring{
        // 单向环形链表
        class RingNode{
            int val;
            RingNode next;

            public RingNode(int val){
                this.val = val;
                this.next = null;
            }
        }

        public RingNode head = null;
        public RingNode tail = null;
        public RingNode cur = null;

        // 添加元素
        public void add(int val){
            if(head == null){
                head = new RingNode(val);
                head.next = head;
                cur = head;
                tail = head;
            }else{
                // 新添加的元素放在循环链表的末尾
                tail = new RingNode(val);
                tail.next = head;
                cur.next = tail;
                cur.next.next = head;
                cur = cur.next;
            }
        }

        // 删除元素
        public boolean delete(int m){
            // 循环链表中只剩余一个元素
            if(head.next == head){
                return false;
            }

            // 确定待删除的元素
            RingNode todel = cur;
            for(int i = 1; i < m; i++){
                cur = todel;// cur移动到待删除的元素的前一个位置
                todel = todel.next;
            }

            // 待删除的元素为从当前节点开始的第二个指针
            if(head == todel){
                // 待删除的节点是头指针
                head = head.next;
                tail.next = head;
                cur = head;
            }else if(tail == todel){
                // 待删除的节点是尾指针
                RingNode p = head;
                while(p.next != tail){
                    p = p.next;
                }
                tail = p;
                tail.next = head;
                cur = head;
            }else{
                // 待删除的节点不是头尾指针
                cur.next = todel.next;
                cur = todel.next;
            }

            return true;
        }
    }

    /**
     *
     * @param n int整型
     * @param m int整型
     * @return int整型
     */
    public static int ysf (int n, int m) {

        Ring ring = new Ring();
        // 添加元素到队列中
        for(int i = 0; i < n; i++){
            ring.add(i + 1);
        }
        // 将当前节点重新定位到头结点
        ring.cur = ring.head;
        // 循环删除
        while(ring.delete(m));

        return ring.head.val;
    }

    public static void main(String[] args) {
        // 43,9001,25
        System.out.println(ysf(43,9001));
    }
}
