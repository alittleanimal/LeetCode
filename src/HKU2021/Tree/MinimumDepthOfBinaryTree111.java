package HKU2021.Tree;

public class MinimumDepthOfBinaryTree111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);

        if (minLeft == 0 || minRight == 0)
            return minLeft + minRight + 1;

        return Math.min(minLeft, minRight) + 1;
    }
}
