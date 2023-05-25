// 40.组合总和Ⅱ
// 思路分析：candidates元素可重复且每个元素只可用一次，需要对结果去重
// 注意同39 区别开
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracing(candidates,target,0,0);
        return res;
    }
    public void backtracing(int[] candidates,int target, int index,int curNum){
        if(curNum == target){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = index ; i < candidates.length; i++){
            // 巧妙地去重法，并没有影响不同的重复元素的使用
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(curNum + candidates[i] > target){
                break;
            }
            list.add(candidates[i]);
            backtracing(candidates,target,i+1, curNum+candidates[i]);
            list.removeLast();
        }
    }
}
