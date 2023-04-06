// 力扣226.翻转二叉树
// 思路分析：每个节点都翻转自己的左右孩子
// 1 递归 2 BFS
import java.util.LinkedList;
public class Solution {
    // 递归
    public TreeNode invertTreeRecursion(TreeNode root) {
        inverse(root);
        return root;
    }
    public void inverse(TreeNode node){
        if(node ==null)
            return;
        inverse(node.left);
        inverse(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        return;
    }
    // BFS翻转
    public TreeNode invertTreeIteration(TreeNode root) {
		if(root==null) {
			return null;
		}
		//将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			//每次都从队列中拿一个节点，并交换这个节点的左右子树
			TreeNode tmp = queue.poll();
			TreeNode left = tmp.left;
			tmp.left = tmp.right;
			tmp.right = left;
			//如果当前节点的左子树不为空，则放入队列等待后续处理
			if(tmp.left!=null) {
				queue.add(tmp.left);
			}
			//如果当前节点的右子树不为空，则放入队列等待后续处理
			if(tmp.right!=null) {
				queue.add(tmp.right);
			}
			
		}
		//返回处理完的根节点
		return root;
	}
}
