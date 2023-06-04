// 78.�Ӽ�
// ˼·�������Ӽ��ͻ��ݣ�������ͻ��ݷǳ����ƣ����������Ӽ���ans����ӽ��λ�ã����ֻҪ���ս�����Ӽ���Ҫ�����е����м��ϣ�
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class S {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<Integer>());
        backtracing(nums,0);
        return ans;
    }
    public void backtracing(int[] nums, int cur){
        if(cur == nums.length){
            return;
        }
        for(int i = cur; i < nums.length; i++){
            list.add(nums[i]);
            ans.add(new ArrayList(list));
            backtracing(nums,i+1);
            list.removeLast();
        }
    }
}

public class Solution{
    public static void main(String[] args){
        S solution = new S();
        int[] nums = {1,2,3};
        solution.subsets(nums);
    }
}