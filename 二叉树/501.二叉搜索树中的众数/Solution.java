// ����501 �����������е����������ף��Ż���O(1)�Ŀռ临�Ӷȣ�
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
    // ���ף�Morris����,���ռ临�Ӷ���O(N)����O(1)
    ArrayList<Integer> ans = new ArrayList<>();
    public int[] findMode2(TreeNode root) {

        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null){
            if(cur.left ==null){
                update(cur);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            // pre.right����cur.val����null
            while(pre.right!=cur && pre.right!=null){
                pre = pre.right;
            }
            if(pre.right == null){
                pre.right = cur;
                // ����Ѱ��ǰ��
                cur = cur.left;
            }
            // ������ǰ���ڵ���,ֱ��update��ǰ�ڵ㣬Ȼ����right�ڵ�
            if(pre.right ==cur){
                update(cur);
                cur = cur.right;
            }
        }
        int [] res =new int [ans.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = ans.get(i);
        }
        return res;
        
    }
    void update(TreeNode cur){
        if(cur.val == base){
            count++;
        }else{
            count =1;
            base = cur.val;
        }
        if(count > maxCount){
            maxCount = count;
            ans.clear();
            ans.add(base);
        }else if(count == maxCount){
            ans.add(base);
        }
    }
}