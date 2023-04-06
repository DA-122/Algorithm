// ����222 ��ȫ�������Ľڵ����
// �ⷨ1 BFS
// �ⷨ2 DFS
// �ⷨ3 ̽��ȣ� ����������������,�ݹ�
// ��ȫ����������������������һ����һ������������
// ��ȫ������������Ҳ����ȫ������
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = 1;
        int rightDepth = 1;
        TreeNode left =root;
        TreeNode right = root;
        while(left.left!=null){
            leftDepth++;
            left = left.left;
        }
        while(right.right!=null){
            rightDepth++;
            right = right.right;
        }
        // ��������������ͷ��ؽڵ����
        if(leftDepth == rightDepth){
            return (int)Math.pow(2,leftDepth)-1;
        }
        // ������������������������������+1
        return countNodes(root.left) + countNodes(root.right)+1;
    }
}