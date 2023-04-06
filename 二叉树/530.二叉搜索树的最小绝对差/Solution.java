// ����530. ��������������С���Բ�
// ˼·���������������������ӱȸ�С���Һ��ӱȸ����������˳��Ϊ����
// �����������
public class Solution{
    public static  int getMinimumDifference(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        int lastVal = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;        
        while(!stack.isEmpty()||curNode!=null){
            if(curNode!=null){
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                curNode = stack.pop();
                ans = Math.min(ans,Math.abs(lastVal-curNode.val));
                lastVal = curNode.val;
                curNode = curNode.right;
            }
        }
        return ans;
    }
}