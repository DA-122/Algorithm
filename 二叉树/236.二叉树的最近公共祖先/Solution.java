// 236. �������������������
// ��Ŀ����������������ȵĶ���Ϊ���������и��� T �������ڵ� p��q������������ȱ�ʾΪһ���ڵ� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
// ˼·������p��q��������������������������:
// 1. p��q�ֱ���node����������
// 2. node����p��q��q��p��������
// �ݹ������⣬�ݹ麯�������Ƿ���p��q
// 
// ��ϣ��洢���ڵ�Ҳ��ʵ�֣� �Ӹ��ڵ㿪ʼ�������������ù�ϣ��洢ÿ���ڵ�ĸ��ڵ�
// Ȼ���p��ʼ��������������¼���ʵ��Ľڵ㣬�ٴ�q����������,�����ĵ�һ��p���ʹ��Ľڵ���ǹ������ڵ�
public class Solution{
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }
    public boolean dfs(TreeNode node,TreeNode p, TreeNode q){
        if(node == null){
            return false;
        }
        boolean l = dfs(node.left,p,q);
        boolean r = dfs(node.right,p,q);
        if((l&&r)|| (node.val == p.val || node.val == q.val) && (l || r)){
            ans = node;
        }
        return l||r||(node.val == p.val || node.val == q.val);
    }

}