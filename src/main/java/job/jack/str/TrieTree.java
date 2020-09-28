package job.jack.str;

import java.util.*;

/**
 * 字典树
 */
public class TrieTree {
    // 字典树的数据结构
    public static class TrieTreeNode {
        public int count = 0;// 统计单次出现的次数
        public int pre_word_count = 0;// 以当前字符为前缀的单词的个数
        public Map<Character, TrieTreeNode> child = new HashMap<>();// 当前节点的子节点

        public TrieTreeNode() {

        }

        public static TrieTreeNode root = new TrieTreeNode();// 根节点

        // 添加word，可重复添加
        public static void insert(String word) {
            int len = word.length();
            TrieTreeNode cur = root;

            for (int i = 0; i < len; i++) {
                Character ch = word.charAt(i);
                // 不包含前缀，则创建
                if (!cur.child.containsKey(ch)) {
                    cur.child.put(ch, new TrieTreeNode());
                }
                cur.child.get(ch).pre_word_count++;
                cur = cur.child.get(ch);
            }
            // 单词数量加1
            cur.count++;
            // 更新根节点的信息
            root.count++;
        }

        // 删除word，如果word添加过多次，仅删除一次
        public static void delete(String word) {
            if(word == null || word.equals("") || !search(word)) return ;
            TrieTreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(--node.child.get(ch).pre_word_count == 0){
                    node.child.remove(ch);
                    return;
                }
                node = node.child.get(ch);
            }
            node.count--;
        }

        // 查询word是否在字典树中出现过(完整的出现过，前缀式不算)
        public static boolean search(String word) {
            int len = word.length();
            TrieTreeNode cur = root;
            for (int i = 0; i < len; i++) {
                Character ch = word.charAt(i);
                if (cur.child.containsKey(ch)) {
                    if (i == len - 1 && cur.child.get(ch).count > 0) {
                        return true;
                    }
                    cur = cur.child.get(ch);
                } else {
                    return false;
                }
            }
            return false;
        }

        // 返回以字符串pre作为前缀的单词数量
        public static int prefixNumber(String pre) {
            int len = pre.length();
            TrieTreeNode cur = root;
            for (int i = 0; i < len; i++) {
                Character ch = pre.charAt(i);
                if (cur.child.containsKey(ch)) {
                    cur = cur.child.get(ch);
                } else {
                    return 0;
                }
            }

            return cur.pre_word_count;
        }

        /**
         * 前序遍历字典树
         *
         * @param root
         */
        public static void preTraverse(TrieTreeNode root) {
            if (root.child.isEmpty()) {
                System.out.println();
            }
            for (Map.Entry<Character, TrieTreeNode> entry : root.child.entrySet()) {
                System.out.print(entry.getKey() + "[" + entry.getValue().pre_word_count + "," + entry.getValue().count + "] -> ");
                preTraverse(entry.getValue());
            }
        }
    }

    /**
     * @param operators string字符串二维数组 the ops
     * @return string字符串一维数组
     */
    public static String[] trieU(String[][] operators) {
        // write code here
        List<String> result = new ArrayList<String>();
        int m = operators.length;
        int n = operators[0].length;
        for (int i = 0; i < m; i++) {
            if (operators[i][0].equals("1")) {
                TrieTreeNode.insert(operators[i][1]);
            } else if (operators[i][0].equals("2")) {
                TrieTreeNode.delete(operators[i][1]);
            } else if (operators[i][0].equals("3")) {
                boolean flag = TrieTreeNode.search(operators[i][1]);
                if (flag) {
                    result.add("YES");
                } else {
                    result.add("NO");
                }
            } else {
                int count = TrieTreeNode.prefixNumber(operators[i][1]);
                result.add(count + "");
            }
        }
        String[] res = new String[result.size()];
        result.toArray(res);
        return res;
    }


    public static void main(String[] args) {
        // a, to, tea, ted, ten, i, in, inn
        String[][] ops = {{"1", "qwer"}, {"1", "qwe"}, {"1", "a"}, {"1", "to"}, {"1", "tea"}
                , {"1", "ted"}, {"1", "ten"}, {"1", "i"}, {"1", "in"}, {"1", "inn"}
                , {"3","qwer"}, {"4","q"}, {"2","qwer"}, {"3","qwer"}, {"4","q"}
        };
        System.out.println(Arrays.toString(trieU(ops)));
        TrieTreeNode.preTraverse(TrieTreeNode.root);
    }
}
