import java.util.*;

/**
 *
 * 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

 1
 / \
 2   2
 / \ / \
 3  4 4  3

 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/symmetric-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSymmetric {

    /**
     * Iteration
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> recordQueue = new LinkedList<>();
        if (root == null) {
            return true;
        }
        recordQueue.add(root.left);
        recordQueue.add(root.right);

        List<Integer> valueList = new ArrayList<>();
        int count = 0;
        while (!recordQueue.isEmpty()) {
            count = recordQueue.size();
            if (count %2 != 0) {
                return false;
            }
            for (int i = 0; i< count; i++) {
                TreeNode node = recordQueue.poll();
                if (node != null) {
                    recordQueue.add(node.left);
                    recordQueue.add(node.right);
                    valueList.add(node.val);
                } else {
                    valueList.add(null);
                }
            }

            for (int i =0, j = valueList.size()-1; i < j;) {
                if (valueList.get(i) != valueList.get(j)) {
                    return false;
                }
                i++;
                j--;
            }

            valueList.clear();
        }
        return true;
    }

    /**
     * Recursion
     * @param root
     * @return
     */
    public boolean isSymmetricRecur(TreeNode root) {
        if(root == null) {
            return true;
        }
        return symmetricCore(root.left, root.right);
    }
    private boolean symmetricCore(TreeNode left, TreeNode right) {
        if (left==null && right == null) {
            return true;
        }else if (left != null && right != null) {
            return symmetricCore(left.left, right.right) && symmetricCore(left.right, right.left);
        } else {
            return false;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> recordQueue = new ArrayDeque<>();
        List<List<Integer>> returnList = new ArrayList<>();
        if (root == null) {
            return returnList;
        }
        recordQueue.add(root);
        int levelCount = 0;
        while (!recordQueue.isEmpty()) {
            levelCount = recordQueue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i< levelCount; i++) {
                TreeNode node = recordQueue.poll();
                levelList.add(node.val);
                if (node.left != null)
                    recordQueue.add(node.left);
                if (node.right != null)
                    recordQueue.add(node.right);
            }
            returnList.add(levelList);
        }
        return returnList;
    }

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(0);
//        treeNode.right = new TreeNode(2);
//        treeNode.left.left = new TreeNode(3);
//        treeNode.left.right = new TreeNode(4);
//        treeNode.right.left = new TreeNode(4);
//        treeNode.right.right = new TreeNode(4);

        System.out.println(isSymmetric.isSymmetric(treeNode));
    }
}
