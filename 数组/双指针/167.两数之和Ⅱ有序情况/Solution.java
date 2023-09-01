// ����167 ����֮�� �������
// ˼·�� ���򣺹�ϣ�� ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n)
// ���� ˫ָ�� ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right =  n - 1;
        int [] res = {left , right};

        while(left < right){
            if(numbers[left] + numbers[right] < target){
                left++;
            }else if(numbers[left] + numbers[right] > target){
                right--;
            }else{
                res[0] = left+1;
                res[1] = right+1;
                break;
            }
        }
        return res;
 
    }
}