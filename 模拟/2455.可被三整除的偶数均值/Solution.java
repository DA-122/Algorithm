// 力扣2455. 可被3整除的偶数均值
// 思路分析：被6整除的数的均值，遍历

public class Solution {
    public int averageValue(int[] nums) {
        int result = 0;
        int total = 0;
        for(int num: nums){
            if(num % 6 ==0){
                result+=num;
                total +=1;
            }
        }
        return total == 0? total:result/total;
    }
}
