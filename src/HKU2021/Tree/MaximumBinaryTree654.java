package HKU2021.Tree;

import org.junit.Test;

import java.util.Arrays;

public class MaximumBinaryTree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int index = findMax(nums);
        TreeNode treeNode = new TreeNode(nums[index]);

        if (index > 0) {
            treeNode.left = constructMaximumBinaryTree(Arrays.copyOf(nums, index));
        }
        if (index < nums.length - 1) {
            treeNode.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length));
        }
        return treeNode;
    }

    private int findMax(int[] nums) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    @Test
    public void test654() {
        System.out.println(constructMaximumBinaryTreeBetterSol(new int[]{3, 2, 1, 6, 0, 5}).val);
    }


    public TreeNode constructMaximumBinaryTreeBetterSol(int[] nums) {
        return constructMaximumBinaryTreeBetterSol(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTreeBetterSol(int[] nums, int from, int to) {
        if (from >= to)
            return null;

        int index = findRangeMax(nums, from, to);
        TreeNode treeNode = new TreeNode(nums[index]);

        treeNode.left = constructMaximumBinaryTreeBetterSol(nums, from, index);
        treeNode.right = constructMaximumBinaryTreeBetterSol(nums, index + 1, to);

        return treeNode;
    }

    private int findRangeMax(int[] nums, int from, int to) {
        int max = -1;
        int index = -1;
        for (int i = from; i < to; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
