// 力扣11 盛放最多水的容器
// 思路分析： 注意此题容量仅和左右边界有关
// area =  (right - left)*(min(height[right],height[left]))
// 思路：双指针法，left向右，right向左，
// left right中必定一个长板 一个短板，短板和宽决定面积
// 长板移动只会引起面积减小，短板移动可能带来面积增加（贪心思想）


public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length;
        while(left < right){
            max =Math.max((right - left)*Math.min(height[left],height[right]) ,max);
            // 短板移动
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }

        }
        return max;
    }
}
