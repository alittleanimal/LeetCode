package HKU2021.Tree;

/**
 * 226. Invert Binary Tree
 */
public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }
}
