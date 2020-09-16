package jack.algo;

import java.util.*;

/**
 * LRU算法实现
 * 链表+HashMap实现
 */
public class LRU {
    // 定义链表结构
    static class Node {
        int key;
        int value;
        Node next;
    }

    // 链表容量
    private static int SIZE = 3;
    private static Node head = null;

    // hash表用于查询
    private static Map<Integer, Node> map = new HashMap<>();

    /**
     * 添加节点
     *
     * @param key
     * @param value
     */
    public static void set(int key, int value) {
        if (map.size() >= SIZE) {
            // 移除最不常使用的缓存
            // 1.移除链表的尾部
            Node removed = removeLast(head);

            // 2.删除map中的值
            map.remove(removed.key);
        }

        // 创建节点，并将当前节点保存到链表里面
        Node node = new Node();
        node.key = key;
        node.value = value;
        Node toAdd = addFirst(node);

        // 将当前节点存入到HashMap中
        map.put(key, toAdd);
    }

    /**
     * 每次将访问的节点移到前面
     *
     * @param key
     * @return
     */
    public static Node get(int key) {
        // 判断当前访问的节点是否为头节点，若是，则直接返回，否则，将其移动到链表头
        if (head.value == key) {
            return head;
        } else {
            // 移除节点
            Node removed = removeNodeByKey(head, key);
            // 添加到链表头
            if (removed != null) {
                addFirst(removed);
            }
            return removed;
        }
    }

    /**
     * 添加到链表头
     *
     * @param node
     * @return
     */
    public static Node addFirst(Node node) {

        // 判断链表是否为空
        if (map.isEmpty()) {
            node.next = null;
            head = node;
        } else {
            // 将表头数据删除
            node.next = head;
            head = node;
        }
        return node;
    }

    /**
     * 移除末尾节点
     *
     * @param head
     * @return
     */
    public static Node removeLast(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = head.next;
        // 如果next为最后一个节点，则不再移动
        while (next.next != null) {
            cur = cur.next;
            next = next.next;
        }
        cur.next = null;
        return next;
    }


    /**
     * 移除指定节点
     *
     * @param head
     * @param key
     * @return
     */
    public static Node removeNodeByKey(Node head, int key) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = head.next;
        // 将next指针指向要移除的结点
        while (next != null && next.key != key) {
            cur = cur.next;
            next = next.next;
        }
        // next指针为空，代表没有找到指定key的节点，直接返回null
        if(next == null){
            return null;
        }
        // 否则，将当前指针指向next指针的下一个节点
        cur.next = next.next;
        next.next = null;
        // 返回移除的节点
        return next;
    }


    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public static int[] LRU(int[][] operators, int k) {
        List<Integer> list = new ArrayList<>();
        SIZE = k;
        // 思路就是每次判断访问的
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                int key = operators[i][1];
                int value = operators[i][2];
                // 放入缓存
                set(key, value);
            } else if (operators[i][0] == 2) {
                // 获取结果
                int key = operators[i][1];
                Node node = get(key);
                if (node != null) {
                    list.add(node.value);
                } else {
                    list.add(-1);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int k = 3;

        int[] res = LRU(operators, k);
        System.out.println(Arrays.toString(res));
    }
}
