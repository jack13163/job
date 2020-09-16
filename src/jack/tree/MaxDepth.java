package jack.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 求二叉树的最大深度
 */
public class MaxDepth {

    /**
     * 二叉树数据结构
     */
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }


    /**
     * 按照层次进行遍历
     *
     * @param root TreeNode类
     * @return int整型
     */
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        // 初始化
        List<List<TreeNode>> nodes = new LinkedList<>();
        List<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        nodes.add(nodeList);

        // 利用队列实现广度优先遍历
        int k = 0;
        List<TreeNode> nextLevel = null;
        do {
            nextLevel = new ArrayList<>();
            // 遍历当前层，添加到下一层
            List<TreeNode> curLevel = nodes.get(k);

            for (int i = 0; i < curLevel.size(); i++) {
                TreeNode treeNode = curLevel.get(i);

                if (treeNode.left != null) {
                    nextLevel.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLevel.add(treeNode.right);
                }
            }
            if(!nextLevel.isEmpty()){
                nodes.add(nextLevel);
            }
            k++;
        } while (!nextLevel.isEmpty());
        return k;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        System.out.println(maxDepth(root));
        maxDepth(null);
    }
}
