// 力扣 491.递增子序列
// 思路分析:递增子序列 子集回溯
// 后一个元素与前一个元素相等也是递增
// 回溯树的每一层中元素一定不能重复
// 回溯树 节点元素一定 >= 孩子元素

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class S {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<Integer>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracing(nums,0);
        return ans;
    }
    public void backtracing(int [] nums, int cur){
        // 在回溯树的每一层上进行去重
        Set<Integer> set = new HashSet<>();
        for(int i = cur; i < nums.length; i++){
            // 如果后一个数比前一个数小就continue
            // list.size == 0时，直接加进去
            if(set.contains(nums[i]) || list.size() > 0 && nums[i] < list.get(list.size()-1)){
                continue;
            }
            list.add(nums[i]);
            set.add(nums[i]);
            if(list.size() >= 2){
                ans.add(new ArrayList(list));
            }
            backtracing(nums,i+1);
            list.removeLast();
        }
    }
}
public class Solution{
    public static void main(String[] args){
        S solution = new S();
        int[] nums = {4,4,3,2,1};
        solution.findSubsequences(nums);
    }
}