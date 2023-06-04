// 力扣46. 全排列
// 思路分析：排列型回溯，且数组nums中元素互不相同
// 假如有n个元素，回溯树有n层，第i层有n-i个元素
// 用一个set来记录第i层之前的层元素，每层都将不在set中的元素加入
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtracing(nums,new HashSet<Integer>());
        return ans;
    }
    public void backtracing(int[]nums, Set<Integer> set){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            set.add(nums[i]);
            backtracing(nums,set);
            list.removeLast();
            set.remove(nums[i]);
        }
    }
}