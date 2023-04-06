// ����501 �����������е�����
// ˼·����������Ķ�����������һ��Ĳ�ͬ������������С�ڵ��ڸ������������Դ��ڵ��ڸ���
// 
import java.util.ArrayList;

public class Solution{
    int maxCount;
    int base;
    int count;
    ArrayList<Integer> answer = new ArrayList<>();
    // ��һ�ַ��� �ݹ����������������������������
    // ʱ�临�Ӷȣ�O(n) �ռ临�Ӷ�O(N)
    public int[] findMode(TreeNode root) {
        maxCount = 0;
        count = 0;
        base = 1000001;
        dfs(root);
        int[] ans = new int[answer.size()];
        for(int i = 0; i< ans.length;i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if(node.val == base){
            count++;
        }else{
            count = 1;
            base = node.val;      
        }
        if(count > maxCount){
            maxCount = count;
            answer.clear();
            answer.add(base);
        }else if (count == maxCount){
            answer.add(base);            
        }      
        dfs(node.right);
    }
}