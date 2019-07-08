import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class AverageOfLevels {
	
	
	/**
	 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
	 * 
		示例 1:
		
		输入:
		    3
		   / \
		  9  20
		    /  \
		   15   7
		输出: [3, 14.5, 11]
		解释:
		第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
		
	 * @param root
	 * @return
	 */
	public List<Double> averageOfLevels(TreeNode root) {
		if (root == null) {
			return new ArrayList<Double>();
		}
		
		Queue<TreeNode> bfsQueue = new LinkedList<TreeNode>();
		bfsQueue.add(root);
		double partSum = 0;
		double partCount = 0;
		List<Double> returnList = new ArrayList<Double>();
		while(!bfsQueue.isEmpty()) {
			// initialize
			partCount = bfsQueue.size();
			double count = partCount;
			partSum = 0;
			
			// every layer
			while (partCount > 0) {
				TreeNode top = bfsQueue.poll();
				partSum += top.val;
				if (top.left != null) 
					bfsQueue.add(top.left);
				if (top.right != null)
					bfsQueue.add(top.right);
				partCount --;
			}
			
			returnList.add(partSum/count);
		}
		return returnList;
    }
	
	/**
	 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

		例如:
		给定二叉树: [3,9,20,null,null,15,7],
		
		    3
		   / \
		  9  20
		    /  \
		   15   7
		返回其层次遍历结果：
		
		[
		  [3],
		  [9,20],
		  [15,7]
		]

	 * @param root
	 * @return
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
    	if (root == null) {
			return new ArrayList<>();
		}
    	List<List<Integer>> returnList = new ArrayList<>();
    	int size = 0;
    	Queue<TreeNode> bfsQueue = new LinkedList<>();
    	bfsQueue.add(root);
    	
    	while (!bfsQueue.isEmpty()) {
    		size = bfsQueue.size();
    		List<Integer> tempRecordList = new ArrayList<>();
    		while (size > 0) {
    			TreeNode top = bfsQueue.poll();
    			tempRecordList.add(top.val);
    			if (top.left != null)
    				bfsQueue.add(top.left);
    			if (top.right != null) 
    				bfsQueue.add(top.right);
    			size --;
    		}
    		returnList.add(tempRecordList);
    	}
		return returnList;
    }
}
