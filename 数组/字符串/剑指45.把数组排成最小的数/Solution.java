// 剑指45. 把数组排成最小的数
// 思路分析： 自定义排序题
// 要求：nums中的数组合成字符串的数最小，那么就看如何对nums进行一个排序/
// 设nums数组中任意两数字字符串为 X，Y
// 如果 X + Y > Y + X，则 X > Y(在Y之后)
// 反之在Y之前


import java.util.Arrays;

public class Solution{

    public String minNumber(int[] nums) {
        StringBuffer buffer = new StringBuffer();
        String[] strs = new String[nums.length];
        for(int i = 0; i < strs.length; i++){
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, (a,b) -> {
            return (a+b).compareTo(b+a);
        });
        for(String str: strs){
            buffer.append(str);
        }
        return buffer.toString();
    
    }
}
