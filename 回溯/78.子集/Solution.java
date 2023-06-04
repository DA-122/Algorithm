// 78.子集
// 思路分析：子集型回溯，和组合型回溯非常相似，区别在于子集向ans中添加解的位置（组合只要最终结果，子集需要过程中的所有集合）
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