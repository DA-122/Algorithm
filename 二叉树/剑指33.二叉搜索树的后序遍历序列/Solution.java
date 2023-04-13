// 二叉搜索树,左孩子小于根，右孩子大于根

// 中序遍历 左中右 一定是递增
// 后序遍历 左右中
// 递归查看右子树是否均大于根节点
// 时间复杂度O(n) 空间复杂度O(n)
public class Solution{
    public static boolean verifyPostorder(int[] postorder) {
        return isPostOrder(postorder,0,postorder.length-1);
    }
    // end是root
    public static boolean isPostOrder(int[]postorder, int start, int end){
        if(start >= end)
            return true; 
        int root = postorder[end];
        int rStart = end; 
        // 找到右子树
        for(int i = start; i < end; i++){
            if(postorder[i] > root){
                rStart = i;
                break;
            }
        }
        // 右子树必须全部大于根节点
        for(int i = rStart; i < end; i++){
            if(postorder[i] < root){
                return false;
            }
        }
        return isPostOrder(postorder,start,rStart-1)&&isPostOrder(postorder,rStart,end-1);
    }
    public static void main(String[] args){
        int [] postorder = {1,6,3,2,5};
        System.out.println(verifyPostorder(postorder));
    }
}