// 力扣1637
// 思路分析：排序+一次遍历
import java.util.Arrays;

public class Solution {
    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(int[]a,int[]b) -> {return a[0]==b[0]? a[1]-b[1]:a[0]-b[0];});
        int ans = 0;
        for (int i = 1; i < points.length; i++){
            ans = Math.max(points[i][0]-points[i-1][0],ans);
        }
        return ans;
    }
    public static void main(String [] args){
        int[][] points = {{8,7},{9,9},{7,4},{9,7}};
        System.out.println(maxWidthOfVerticalArea(points));
    }
}