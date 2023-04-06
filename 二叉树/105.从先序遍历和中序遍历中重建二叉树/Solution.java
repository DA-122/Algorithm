// 力扣105. 从先序遍历和中序遍历中重建二叉树
// 思路分析： 1. 递归 + 哈希
// 2. 
public class Solution{
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length-1;
        return build(preorder,inorder,0,n,0,n);
    }
    public static TreeNode build(int[] preorder, int[] inorder,int startPre, int endPre,int startIn, int endIn){
        if(startIn > endIn){
            return null;
        }
        int mid = preorder[startPre];
        int inPosition = findMid(inorder,startIn,endIn,mid);
        TreeNode node = new TreeNode(mid);
        node.left = build(preorder,inorder,startPre+1,startPre+inPosition-startIn,startIn,inPosition-1);
        node.right = build(preorder,inorder,startPre+inPosition-startIn+1,endPre,inPosition+1,endIn);
        return node;
    }
    public static int findMid(int[] inorder, int start, int end, int target){
        int position = 0;
        for(int i = start; i <= end; i++){
            if(inorder[i] == target){
                position = i;
                break;
            }
        }
        return position;
    }
    
    public static void main(String[] args){
        int[] preorder = {};
        int[] inorder = {};
        System.out.println(buildTree(preorder, inorder));
    }
}