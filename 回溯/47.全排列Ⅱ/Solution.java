// 力扣47. 全排列Ⅱ
// 思路分析：排列型回溯，数组nums中元素可以有重复 - 两个set
// 同层： 每一层中只能有一个重复元素  - 层set
// 非同层同路径：每条路径记录已经用过的元素的位置（用值会导致不同层的元素不可用） - 路径set
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;



public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        backtracing(nums,new HashSet<Integer>());
        return ans;
    }
    public void backtracing(int[]nums, Set<Integer> set){
        Set<Integer> setInner = new HashSet<Integer>();
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(set.contains(i) || setInner.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            set.add(i);
            setInner.add(nums[i]);
            backtracing(nums,set);
            list.removeLast();
            set.remove(i);
        }
    }
}