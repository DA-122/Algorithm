// ���� 491.����������
// ˼·����:���������� �Ӽ�����
// ��һ��Ԫ����ǰһ��Ԫ�����Ҳ�ǵ���
// ��������ÿһ����Ԫ��һ�������ظ�
// ������ �ڵ�Ԫ��һ�� >= ����Ԫ��

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
        // �ڻ�������ÿһ���Ͻ���ȥ��
        Set<Integer> set = new HashSet<>();
        for(int i = cur; i < nums.length; i++){
            // �����һ������ǰһ����С��continue
            // list.size == 0ʱ��ֱ�Ӽӽ�ȥ
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