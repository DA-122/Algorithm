// 90.子集Ⅱ
// 思路分析：78 子集中nums元素不重复，90子集中nums元素可重复
// 可以先对nums元素进行一个排列，在构建树时，每一层，同一个元素只加入第一个
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

class S {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        ans.add(new ArrayList<Integer>());
        backtracing(nums,0);
        return ans;
    }
    public void backtracing(int[] nums, int cur){
        if(cur == nums.length){
            return;
        }
        for(int i = cur; i < nums.length; i++){
            // 这里 i > cur来保证不同层都有这个元素 
            if(i > cur && nums[i] == nums[i-1]){
                continue;
            }
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
        int[] nums = {1,2,2};
        List<List<Integer>> ans = solution.subsetsWithDup(nums);
        for(List<Integer> list: ans){
            for(int num: list){
                System.out.print(num + "  ");
            }
            System.out.print("\n");
        }
    }
}