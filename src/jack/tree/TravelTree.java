package jack.tree;

import java.util.ArrayList;

/**
 * 树的遍历
 */
public class TravelTree {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        levelOrder(root);
    }
}
