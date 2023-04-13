// ����538.�Ѷ���������ת��Ϊ�ۼ���
// ��Ŀ������ �ۼ�����ÿ���ڵ� node ����ֵ����ԭ���д��ڻ���� node.val ��ֵ֮�͡�
// ˼·������ 1.�ݹ�
// 2. ʹ��һ������������������������ݹ�  ʱ��O(N)  �ռ�O(N)
// 3. ����Morris������� ʱ��O(N) �ռ�O(1);
public class Solution{
    public TreeNode convertBST(TreeNode root) {
        dfs(root,0);
        return root;
    }
    // �ݹ鷨(�Ե�����)
    public int dfs(TreeNode node,int parentSum){
        if(node == null){
            return 0;
        }
        // ���ұ�,�����
        int rightSum = dfs(node.right,parentSum);
        int leftSum = dfs(node.left,node.val+rightSum+parentSum);
        // sum������
        int sum = rightSum+leftSum+node.val;
        node.val = rightSum+node.val+parentSum;
        return sum;
    }

    // ���������������һ��ȫ�ֱ���������⣩
    int sum = 0;
    public TreeNode convertBST2(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
    // Mirros���� ���������ʵ��O(N)���Ӷ�
    public TreeNode convertBSTMorris(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null){
            if(cur.right==null){
                sum+=cur.val;
                cur.val = sum;
                cur = cur.left;
                continue;
            }
            pre = cur.right;
            while(pre.left!=null&&pre.left!=cur){
                pre = pre.left;
            }
            if(pre.left == null){
                pre.left = cur;
                cur = cur.right;
            }
            // ����Ѿ���������
            if(pre.left == cur){
                pre.left = null;
                sum+=cur.val;
                cur.val = sum;
                cur = cur.left;
            }
        }
        return root;
    }
}