// ����701 �����������еĲ������
// ˼·���������ö���������������
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        TreeNode curNode =root;
        TreeNode lastNode =curNode;
        while(curNode!=null){
            lastNode = curNode;
            if(val > curNode.val){
                curNode = curNode.right;
            }else{
                curNode = curNode.left;
            }
        }
        if(val > lastNode.val){
            lastNode.right = new TreeNode(val);
        }else{
            lastNode.left = new TreeNode(val);
        }
        return root;
    }
}
