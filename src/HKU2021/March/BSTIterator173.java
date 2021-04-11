package HKU2021.March;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTIterator173 {
    TreeNode root;
    List<Integer> treeArray;
    Iterator<Integer> iterator;

    public BSTIterator173(TreeNode root) {
        this.root = root;
        treeArray = new ArrayList<>();
        preSearch(root, treeArray);
        iterator = treeArray.iterator();
    }

    public int next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void preSearch(TreeNode node, List<Integer> treeArray) {
        if (node == null) {
            return;
        }

        preSearch(node.left, treeArray);
        treeArray.add(node.val);
        preSearch(node.right, treeArray);

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
