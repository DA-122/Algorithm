// ����235 �����������������������
// ˼·����: �����������������������
// ���ڵ�ǰ�ڵ���˵�����val > p&q, p q�ڵ��ڵ�ǰ�ڵ�������
// val < p&q��p q�ڵ��ڵ�ǰ�ڵ�������
// ����͵��˷ֲ�㣬������Ŀ����
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        while(true){
            if(res.val > p.val && res.val > q.val){
                res = res.left;
            }else if(res.val < p.val && res.val < q.val){
                res = res.right;
            }else{
                break;
            }
        }
        return res;
    }
}
