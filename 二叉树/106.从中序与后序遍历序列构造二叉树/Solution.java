// 力扣106. 中序后序遍历重建二叉树
// 
public class Solution {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int num = postorder.length-1;
        int position = 0;
        // 找到根在中序的位置
        while(postorder[num]!=inorder[position]){
            position++;
        }
        TreeNode root = new TreeNode(postorder[num]);
        root.left = createChild(inorder,postorder,0,position-1,0,position-1);
        root.right = createChild(inorder,postorder,position+1,num,position,num-1);
        return root;
    }
    public static TreeNode createChild(int[] inorder, int[]postorder,int inStart,int inEnd,int postStart, int postEnd){
        if(inEnd<inStart||postStart>postEnd){
            return null;
        }
        if(inEnd == inStart){
            return new TreeNode(inorder[inEnd]);
        }
        int position = inStart;
        while(postorder[postEnd]!=inorder[position]){
            position++;
        }
        TreeNode node = new TreeNode(postorder[postEnd]);
        node.left = createChild(inorder,postorder,inStart,position-1,postStart,postStart+position-inStart-1);
        node.right = createChild(inorder,postorder,position+1,inEnd,position-inStart+postStart,postEnd-1);
        return node;
    }
    public static void main(String[] args){
        int[] inorder = {1,2,3,4,5,6};
        int[] postorder = {1,5,4,6,3,2};
        buildTree(inorder, postorder);
    }
}