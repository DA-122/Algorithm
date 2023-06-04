// 90.�Ӽ���
// ˼·������78 �Ӽ���numsԪ�ز��ظ���90�Ӽ���numsԪ�ؿ��ظ�
// �����ȶ�numsԪ�ؽ���һ�����У��ڹ�����ʱ��ÿһ�㣬ͬһ��Ԫ��ֻ�����һ��
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

class S {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // ������
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
            // ���� i > cur����֤��ͬ�㶼�����Ԫ�� 
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