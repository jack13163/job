package jack.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树的最大深度
 */
public class TravelTree2 {

    /**
     * 二叉树数据结构
     */
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }


    /**
     * @param root TreeNode类
     * @return int整型
     */
    public static int maxDepth(TreeNode root) {
        // write code here
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        // 利用队列实现广度优先遍历
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.println(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        maxDepth(root);
    }
}
