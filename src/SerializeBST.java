import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 */

public class SerializeBST {

    private int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder("");
        this.preOrder(root, res);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String [] node = data.split("!");
        TreeNode root = this.deserializeCode(node);

        return root;

    }

    private void preOrder(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("#!");
        }

        str.append(root.val + "!");

        this.preOrder(root.left, str);

        this.preOrder(root.right, str);
    }

    private TreeNode deserializeCode(String[] strs) {
        if("#".equals(strs[index])) {
            index++;
            return null;
        } else {
            TreeNode newNode = new TreeNode(0);
            newNode.val = Integer.parseInt(strs[index]);

            index++;

            newNode.left = this.deserializeCode(strs);

            newNode.right = this.deserializeCode(strs);

            return newNode;
        }
    }
}
