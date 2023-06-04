// ����47. ȫ���Т�
// ˼·�����������ͻ��ݣ�����nums��Ԫ�ؿ������ظ� - ����set
// ͬ�㣺 ÿһ����ֻ����һ���ظ�Ԫ��  - ��set
// ��ͬ��ͬ·����ÿ��·����¼�Ѿ��ù���Ԫ�ص�λ�ã���ֵ�ᵼ�²�ͬ���Ԫ�ز����ã� - ·��set
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