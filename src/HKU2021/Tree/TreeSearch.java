package HKU2021.Tree;

import org.junit.Test;

import java.util.Stack;

public class TreeSearch {

    public void recursionPreorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            recursionPreorderTraversal(root.left);
            recursionPreorderTraversal(root.right);
        }
    }

    public void preorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;

        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                System.out.println(node.val);
                treeNodeStack.push(node);
                node = node.left;
            }

            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
    }

    public void recursionMiddleorderTraversal(TreeNode root) {
        if (root != null) {
            recursionMiddleorderTraversal(root.left);
            System.out.println(root.val);
            recursionMiddleorderTraversal(root.right);
        }
    }

    public void middleorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;

        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }

    public void recursionPostorderTraversal(TreeNode root) {
        if (root != null) {
            recursionMiddleorderTraversal(root.left);
            recursionMiddleorderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    public void postorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;

        while (node != null || !treeNodeStack.isEmpty()) {
            while (node !=null) {
                treeNodeStack.push(node);
                node = node.left;
            }

            node = treeNodeStack.peek();
            if (node.right == null || node.right == lastVisit) {
                System.out.println(node.val);
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                node = node.right;
            }
        }
    }

    @Test
    public void test() {
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node5 = new TreeNode(5);

        TreeNode node6 = new TreeNode(6, node7, node8);
        TreeNode node4 = new TreeNode(4, null, node6);
        TreeNode node3 = new TreeNode(3, null, node5);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node1 = new TreeNode(1, node2, node3);

//        recursionPreorderTraversal(node1);
//        preorderTraversal(node1);
//        recursionMiddleorderTraversal(node1);
//        middleorderTraversal(node1);
        postorderTraversal(node1);
    }

}
