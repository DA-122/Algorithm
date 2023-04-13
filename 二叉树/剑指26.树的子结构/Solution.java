// ��ָ26 �ж�B�Ƿ�ΪA���ӽṹ
// ˼·������ ˫�ݹ�  ʱ�临�Ӷ�O() �ռ临�Ӷ�()
public class Solution{
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return check(A,B);
    }   
    public static boolean check(TreeNode node, TreeNode B){
        if(node == null||B ==null)
            return false;
        boolean result = false;
        if(node.val == B.val){
            result = dfs(B,node);
        }
        boolean l = check(node.left,B);
        boolean r = check(node.right,B);
        return  result||l||r;
    }
    public static boolean dfs(TreeNode B, TreeNode node){
        if(B == null)
            return true;
        if(node == null && B!=null)
            return false;
        if(B.val == node.val)
            return dfs(B.left,node.left)&&dfs(B.right,node.right);
        else{
            return false;
        }        
    }
}