package HKU2021.LeetCodeCampus;


import org.junit.Test;

import java.util.*;

public class Searching {
    private int currentLevel;

    // 199. 二叉树的右视图
    public List<Integer> rightSideView(TreeNode root) {
        currentLevel = 0;
        List<Integer> res = new ArrayList<>();

        findRightView(root, res, 0);

        return res;
    }

    private void findRightView(TreeNode root, List<Integer> res, int level) {
        if (root == null)
            return;

        if (level == currentLevel) {
            res.add(root.val);
            currentLevel++;
        }

        findRightView(root.right, res, level + 1);
        findRightView(root.left, res, level + 1);
    }

    private List<Integer> rightSideViewDFS(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                max_depth = Math.max(max_depth, depth);

                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<>();
        for (int i = 0; i <= max_depth; i++) {
            rightView.add(rightmostValueAtDepth.get(i));
        }
        return rightView;
    }

    private List<Integer> rightSideViewBFS(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Queue<TreeNode> nodeStack = new LinkedList<>();
        Queue<Integer> depthStack = new LinkedList<>();
        nodeStack.add(root);
        depthStack.add(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.remove();
            int depth = depthStack.remove();

            if (node != null) {
                max_depth = Math.max(max_depth, depth);

                rightmostValueAtDepth.put(depth, node.val);

                nodeStack.add(node.left);
                nodeStack.add(node.right);
                depthStack.add(depth + 1);
                depthStack.add(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<>();
        for (int i = 0; i <= max_depth; i++) {
            rightView.add(rightmostValueAtDepth.get(i));
        }
        return rightView;
    }


    // 46. 全排列
    private int lengthPer;
    private List<List<Integer>> resList;

    public List<List<Integer>> permute(int[] nums) {
        lengthPer = nums.length;
        resList = new ArrayList<>();
        Integer[] integers = new Integer[lengthPer];
        for (int i = 0; i < lengthPer; i++) {
            integers[i] = nums[i];
        }
        getPermute(0, integers);
        return resList;
    }

    private void getPermute(int start, Integer[] nums) {
        if (start == lengthPer - 1) {
            resList.add(new ArrayList<>(Arrays.asList(nums)));
            return;
        }

        for (int i = start; i < lengthPer; i++) {
            swap(nums, i, start);
            getPermute(start + 1, nums);
            swap(nums, start, i);
        }
    }

    private void swap(Integer[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder res = seri(root, new StringBuilder());
        assert res != null;
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private StringBuilder seri(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("/,");
            return null;
        }

        builder.append(root.val);
        builder.append(",");
        seri(root.left, builder);
        seri(root.right, builder);

        return builder;
    }

    // Decodes your encoded data to tree.
    private int index;

    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;

        String[] treeString = data.split(",");
        TreeNode root = new TreeNode();
        index = 0;
        root = buildTree(root, treeString);
        return root;
    }

    private TreeNode buildTree(TreeNode treeNode, String[] treeString) {
        if (index == treeString.length) {
            return treeNode;
        }

        if (treeString[index].equals("/")) {
            index++;
            return treeNode;
        } else {
            treeNode = new TreeNode(Integer.parseInt(treeString[index]));
            index++;
        }

        treeNode.left = buildTree(treeNode.left, treeString);
        treeNode.right = buildTree(treeNode.right, treeString);
        return treeNode;
    }

    // 33. 搜索旋转排序数组
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, target, nums);
    }

    private int binarySearch(int i, int j, int target, int[] nums) {
        int middle = (i + j) / 2;
        if (nums[middle] == target)
            return middle;
        if (i >= j)
            return -1;

        if (nums[middle] >= nums[i]) {
            if (target < nums[middle] && target >= nums[i]) {
                return binarySearch(i, middle - 1, target, nums);
            } else {
                return binarySearch(middle + 1, j, target, nums);
            }
        } else {
            if (target > nums[middle] && target <= nums[j]) {
                return binarySearch(middle + 1, j, target, nums);
            } else {
                return binarySearch(i, middle - 1, target, nums);
            }
        }
    }

    @Test
    public void test() {
//        System.out.println(permute(new int[]{1, 2, 3}));

//        TreeNode root = null;
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = null;
//        root.right.right = new TreeNode(5);
//        System.out.println(serialize(root));
//        System.out.println(deserialize(serialize(root)));

        System.out.println(search(new int[]{3,1}, 1));
    }

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
