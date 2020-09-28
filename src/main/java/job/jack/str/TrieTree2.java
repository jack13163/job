package job.jack.str;

import java.util.*;

/**
 * 字典树
 */
public class TrieTree2 {
    // 字典树的数据结构
    public static class Trie {
        public class TrieNode{
            public int path;
            public int end;
            public HashMap<Character, TrieNode> next;

            public TrieNode(){
                path = 0;
                end = 0;
                next = new HashMap<>();
            }
        }

        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            if(word == null || word.equals(""))  return ;
            TrieNode node = root;
            for(int i = 0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(!node.next.containsKey(ch)) {
                    node.next.put(ch,new TrieNode());
                }
                node = node.next.get(ch);
                node.path++;
            }
            node.end++;
        }

        public boolean search(String word){
            if(word == null || word.equals("")) return false;
            TrieNode node = root;
            for(int i = 0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(!node.next.containsKey(ch)) return false;
                node = node.next.get(ch);
            }
            if(node.end == 0) return false;
            return true;
        }
        public int startsWith(String word){
            if(word == null || word.equals("")) return 0;
            TrieNode node = root;
            for(int i = 0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(!node.next.containsKey(ch)) return 0;
                node = node.next.get(ch);
            }
            return node.path;
        }
        public void delete(String word){
            if(word == null || word.equals("") || !search(word)) return ;
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(--node.next.get(ch).path == 0){
                    node.next.remove(ch);
                    return;
                }
                node = node.next.get(ch);
            }
            node.end--;
        }
    }

    /**
     * @param operators string字符串二维数组 the ops
     * @return string字符串一维数组
     */
    public static String[] trieU(String[][] operators) {
        Trie root = new Trie();
        // write code here
        List<String> result = new ArrayList<String>();
        int m = operators.length;
        int n = operators[0].length;
        for (int i = 0; i < m; i++) {
            if (operators[i][0].equals("1")) {
                root.insert(operators[i][1]);
            } else if (operators[i][0].equals("2")) {
                root.delete(operators[i][1]);
            } else if (operators[i][0].equals("3")) {
                boolean flag = root.search(operators[i][1]);
                if (flag) {
                    result.add("YES");
                } else {
                    result.add("NO");
                }
            } else {
                int count = root.startsWith(operators[i][1]);
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
    }
}
