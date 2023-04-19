// ��ָ56.���������ֳ��ֵĴ�����Ҫ��ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)��
// ����˼·�� ���û�пռ临�Ӷ�Ҫ����Թ�ϣ��ʱ��O(n)���ռ�O(n) ��������ӱ���ʱ��O(nlogn)���ռ�O(1)
// ���: �������

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution{
    // ���˼·���������һ���������⣬�������ֶ����������Σ���ô����ҵ�����һ�ε����֣�
    // �𰸣�ȫԱ��򣬳ɶԳ��ֵ��������Ϊ0��������������ǳ���һ�ε��Ǹ����֡�
    // ���𣺵�����������������һ�ε����֣����Խ��������ֽ��з��飬
    // 1. �ֳ����鲢��֤����ֻ����һ�ε������ڲ�ͬ������
    // 2. ��֤��ͬ�����ֱ��ֵ�һ����ȥ��
    // ��������ͱ�Ϊ����η���
    // ������������һ�ε����ֱַ�Ϊa��b����a^b = x
    // ��xת��Ϊ��������ʽ�� X(i)X(i-1).....X(0)
    // X(i)������1����0��X(i) = 1, a,b��iλ��ͬ; X(i) =0, a,b��iλͬ 
    // ��������ȡһλx(i) = 1, �������е�������˵����x(i)λ��0��1
    // ���Խ�x(i)λ��0�ķ���һ�飬X(i)λ��1�ķ�����һ�飬��������������

    public static int[] singleNumbers(int[] nums) {
        int ans[] = new int[2];
        int x = nums[0];
        
        // ȡ�����յ����
        for(int i = 1 ; i < nums.length; i++){
            x ^=nums[i];
        }
        // ����λ��
        int counter = 0;
        while(x > 0){
            int y = (x>>counter)&1;
            if(y == 1){
                break;
            }else{
                counter++;
            }
        }
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++){
             if(((nums[i]>>counter)&1) == 0){
                left.add(nums[i]);
             }else{
                right.add(nums[i]);
             }
        }
        ans[0] = left.get(0);
        ans[1] = right.get(0);
        for(int i = 1; i < left.size(); i++){
            ans[0] ^= left.get(i);
        }
        for(int i = 1; i < right.size(); i++){
            ans[1] ^= right.get(i);
        }
        
        return ans;
    }


    // ����˼·: ����ӱ��� ʱ��O(nlogn)���ռ�O(1)
    public static int[] singleNumbers2(int[] nums) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        int pivot = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                i++;
            }else{
                ans[pivot] = nums[i];
                pivot++;
            }
        }
        if(pivot == 1){
            ans[pivot] = nums[nums.length-1];
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {6,5,5,9,10,9,4,10};
        singleNumbers(nums);

    }
}