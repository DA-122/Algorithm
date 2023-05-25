// ��39. ����ܺ�
// ˼·����������

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // ������
        Arrays.sort(candidates);
        backtracing(0, candidates, target, 0);
        return res;
    }
    // indexָ��ǰcandidates��λ��
    public void backtracing(int index, int[] candidates, int target,int curNum){
        if(curNum == target){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = index; i  < candidates.length; i++){
            // ��������-��֦
            if(curNum + candidates[i] > target){
                break;
            }
            list.add(candidates[i]);
            // ������i ����i+1(��Ϊ�����ظ�)
            backtracing(i,candidates,target,curNum + candidates[i]);
            list.removeLast();
        }
    }
}



