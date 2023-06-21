/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // ����114.������չ��Ϊ����
 // ˼·������
 // չ����ĵ�����Ӧ��ͬ��ʹ�� TreeNode ������ right ��ָ��ָ����������һ����㣬������ָ��ʼ��Ϊ null ��
 // �ҵ�����Ӧ��������� ������� ˳����ͬ��������� ������
 // �����������һ�������洢�нڵ㣬���ϸ��¼���
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode curNode = null;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(curNode!=null){
                // �������Ӻ��Һ���
                curNode.left = null;
                curNode.right = node;
            }
            // �õ�������
            if(node.right != null){
                stack.push(node.right); 
            }
            if(node.left != null){
                stack.push(node.left);
            }
            curNode = node;
        }
    }
}