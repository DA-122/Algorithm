// ����94 ��֤����������
// ˼·�������������������Ӷ�С�ڸ��ڵ㣬�Һ��Ӷ����ڸ��ڵ�
// 1.�ݹ��㷨�� ����������˵�����ӵ�����һ��С�����ӣ����ӵ��Һ���һ���������ӣ���ҪС�ڸ��ڵ�
// ��˿��������Ͻ���½磬�������ӵ����ӣ��½�Ϊ���ӵ��½磬�Ͻ�Ϊ����
// �������ӵ��Һ��ӣ��½�Ϊ���ӣ��Ͻ�Ϊ���ڵ�
// 2.��������� ������˳�������ֻ��Ҫ�ж��Ƿ�ǰ�ڵ�����������ǰһ���ڵ㣬������ڣ���˵�����㣬���򷵻�false
// ���ۣ��������������������һ��������
public class Solution {
    // �ݹ��㷨
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    // 
    public boolean isValidBST(TreeNode node, long lower, long upper){
        if(node == null)
            return true;
        if(node.val <= lower || node.val >= upper)
            return false;
        return isValidBST(node.left,lower,node.val)&&isValidBST(node.right,node.val,upper);
    }
}