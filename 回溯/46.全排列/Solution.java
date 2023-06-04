// ����46. ȫ����
// ˼·�����������ͻ��ݣ�������nums��Ԫ�ػ�����ͬ
// ������n��Ԫ�أ���������n�㣬��i����n-i��Ԫ��
// ��һ��set����¼��i��֮ǰ�Ĳ�Ԫ�أ�ÿ�㶼������set�е�Ԫ�ؼ���
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