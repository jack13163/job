package jack.tree;

import java.util.*;

/**
 * 寻找任意两个节点的双亲
 */
public class FindParent {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public static int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        travel(root);
        int res = -1;

        // 层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 初始化
        queue.add(root);
        while (!queue.isEmpty()) {
            // 将队列中的子节点全部入队
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            List<Integer> list = map.get(node.val);
            if ((list.contains(o1) && list.contains(o2))
                    || (node.val == o1 && list.contains(o2))
                    || (list.contains(o1) && node.val == o2)) {
                res = node.val;
            }
        }

        return res;
    }

    static Map<Integer, List<Integer>> map = new LinkedHashMap<>();

    // 遍历并找出当前节点的所有子节点
    public static List<Integer> travel(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = map.get(root.val);
        if (list == null) {
            list = new ArrayList<>();
            map.put(root.val, list);
        }

        // 添加子节点
        if (root.left != null) {
            list.add(root.left.val);
            List<Integer> lList = travel(root.left);
            if (lList != null) {
                list.addAll(lList);
            }
        }
        if (root.right != null) {
            list.add(root.right.val);
            List<Integer> rList = travel(root.right);
            if (rList != null) {
                list.addAll(rList);
            }
        }
        return list;
    }

    /**
     * 创建二叉树
     * {27,32,34,19,41,17,18,9,14,44,39,#,#,24,30,#,#,#,2,7,42,28,36,#,#,11,6,#,1,#,#,#,31,16,4,22,33,#,#,#,5,10,15,37,12,8,#,35,3,#,23,21,#,#,#,29,#,#,#,40,#,#,#,#,#,#,#,#,#,13,43,#,#,#,#,#,#,25,20,#,#,38,#,26},32,38
     *
     * @param str
     * @return
     */
    public static TreeNode createTree(String str) {
        str = str.substring(1, str.length() - 1);
        String[] tmp = str.split(",");
        int i = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(tmp[i]);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            // 判断是否为空节点
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            // 左节点
            if(left < tmp.length) {
                if (tmp[left].equals("#")) {
                    node.left = null;
                } else {
                    TreeNode leftNode = new TreeNode();
                    leftNode.val = Integer.parseInt(tmp[left]);
                    node.left = leftNode;
                    queue.add(leftNode);
                }
            }

            // 右节点
            if(right < tmp.length){
                if(tmp[right].equals("#")){
                    node.right = null;
                }else{
                    TreeNode rightNode = new TreeNode();
                    rightNode.val = Integer.parseInt(tmp[right]);
                    node.right = rightNode;
                    queue.add(rightNode);
                }
            }
            i++;
        }

        return root;
    }

    // --------------------------------------------二叉树的层次遍历----------------------------------------------
    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> nodes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        // write code here
        ArrayList<TreeNode> r = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();
        r.add(root);
        r2.add(root.val);
        nodes.add(r);
        result.add(r2);
        // 广度优先遍历
        travel(nodes, result, 1);
        return result;
    }

    // 递归广度优先遍历
    public static void travel(ArrayList<ArrayList<TreeNode>> nodes, ArrayList<ArrayList<Integer>> res, int level) {
        ArrayList<TreeNode> curLevel = nodes.get(res.size() - 1);
        ArrayList<TreeNode> nextLevel = new ArrayList<>();
        ArrayList<Integer> nextVal = new ArrayList<>();
        for (int i = 0; i < curLevel.size(); i++) {
            TreeNode node = curLevel.get(i);
            if (node.left != null) {
                nextLevel.add(node.left);
                nextVal.add(node.left.val);
            }

            if (node.right != null){
                nextLevel.add(node.right);
                nextVal.add(node.right.val);
            }
        }
        // 如果下一层没有节点，就不需要遍历了
        if(!nextLevel.isEmpty()){
            nodes.add(nextLevel);
            res.add(nextVal);
            travel(nodes, res, level + 1);
        }
    }
    // ------------------------------------------------------------------------------------------


    public static void main(String[] args) {
        String str = "{27,32,34,19,41,17,18,9,14,44,39,#,#,24,30,#,#,#,2,7,42,28,36,#,#,11,6,#,1,#,#,#,31,16,4,22," +
                "33,#,#,#,5,10,15,37,12,8,#,35,3,#,23,21,#,#,#,29,#,#,#,40,#,#,#,#,#,#,#,#,#,13,43,#,#,#,#,#,#,25,20,#,#,38,#,26}";
        TreeNode root = createTree(str);
        // 输出创建好的树，验证创建的过程是否出错
        ArrayList<ArrayList<Integer>> lists = levelOrder(root);
        lists.forEach(level->{
            System.out.println(level);
        });
        // 寻找双亲
        System.out.println(lowestCommonAncestor(root, 32, 38));
    }
}
