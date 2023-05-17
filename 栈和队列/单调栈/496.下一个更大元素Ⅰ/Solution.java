// 496.下一个更大元素I 
// 题目分析： 给了两个数组nums1和nums2，nums1是nums2的子集，要求返回nums1中每个元素在nums2中对应位置右侧第一大的数
// 思路分析： 对nums2用单调栈,哈希表保存每个元素右侧大数,然后遍历一遍nums1即可 

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution{
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        map.put(nums2[0],-1);
        for(int i = 1; i < nums2.length; i++){
            map.put(nums2[i],-1);
            if(nums2[i] <= nums2[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&nums2[i] > nums2[stack.peek()]){
                    map.put(nums2[stack.peek()],nums2[i]);
                    stack.pop();
                }
                stack.push(i);
            }
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < res.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
    public static void main(String[] args){
        int []nums1 = {4,1,2};
        int []nums2 = {1,3,4,2};
        nextGreaterElement(nums1, nums2);
    }   
}