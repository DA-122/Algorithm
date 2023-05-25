// 力39. 组合总和
// 思路分析：回溯

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 先排序
        Arrays.sort(candidates);
        backtracing(0, candidates, target, 0);
        return res;
    }
    // index指向当前candidates的位置
    public void backtracing(int index, int[] candidates, int target,int curNum){
        if(curNum == target){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = index; i  < candidates.length; i++){
            // 有序数组-剪枝
            if(curNum + candidates[i] > target){
                break;
            }
            list.add(candidates[i]);
            // 这里用i 不用i+1(因为可以重复)
            backtracing(i,candidates,target,curNum + candidates[i]);
            list.removeLast();
        }
    }
}



