// ����226.��ת������
// ˼·������ÿ���ڵ㶼��ת�Լ������Һ���
// 1 �ݹ� 2 BFS
import java.util.LinkedList;
public class Solution {
    // �ݹ�
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
    // BFS��ת
    public TreeNode invertTreeIteration(TreeNode root) {
		if(root==null) {
			return null;
		}
		//���������еĽڵ�����������У��ٵ�����������е�Ԫ��
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			//ÿ�ζ��Ӷ�������һ���ڵ㣬����������ڵ����������
			TreeNode tmp = queue.poll();
			TreeNode left = tmp.left;
			tmp.left = tmp.right;
			tmp.right = left;
			//�����ǰ�ڵ����������Ϊ�գ��������еȴ���������
			if(tmp.left!=null) {
				queue.add(tmp.left);
			}
			//�����ǰ�ڵ����������Ϊ�գ��������еȴ���������
			if(tmp.right!=null) {
				queue.add(tmp.right);
			}
			
		}
		//���ش�����ĸ��ڵ�
		return root;
	}
}
