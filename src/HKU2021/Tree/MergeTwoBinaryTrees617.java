package HKU2021.Tree;

/**
 * 617. Merge Two Binary Trees
 */
public class MergeTwoBinaryTrees617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;

        if (root1 == null)
            return root2;
        else if(root2 == null)
            return root1;

        TreeNode mergedTree = new TreeNode(root1.val + root2.val);
        mergedTree.left = mergeTrees(root1.left, root2.left);
        mergedTree.right = mergeTrees(root1.right, root2.right);

        return mergedTree;
    }
}
