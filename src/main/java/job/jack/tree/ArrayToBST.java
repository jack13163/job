package job.jack.tree;

/**
 * 将一个升序排序的数组转换为平衡二叉搜索树BST
 */
public class ArrayToBST {

    /**
     * 二叉树节点
     */
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param num int整型一维数组
     * @return TreeNode类
     */
    public static TreeNode sortedArrayToBST(int[] num) {
        // write code here
        int len = num.length;
        // 根节点很好找就是中间的节点，即mid=(start + end) / 2
        int start = 0;
        int end = len - 1;
        TreeNode root = createTree(num, start, end);

        return root;
    }

    // 创建二叉树
    public static TreeNode createTree(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (int)Math.ceil(1.0 * (start + end) / 2.0);
        TreeNode root = new TreeNode(num[mid]);
        root.left = createTree(num, start, mid - 1);
        root.right = createTree(num, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2};
        sortedArrayToBST(arr);
    }
}
