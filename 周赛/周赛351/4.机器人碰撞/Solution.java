// 周赛351. 机器人碰撞
// 思路分析：栈

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution{
    public static void main(String[] args){
        int [] healths = {7,19,9,7,45,30,25};
        int [] positions = {1,24,17,3,47,43,20};
        String directions = "RRRLLRL";
        S s = new S();
        s.survivedRobotsHealths(positions, healths, directions);
    }
}
class S {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int[][] array = new int[positions.length][4];
        for(int i = 0 ; i < positions.length; i++){
            if(directions.charAt(i) == 'L'){
                array[i][2] = -1;
            }else{
                array[i][2] = 1;
            }
            array[i][0] = positions[i];
            array[i][1] = healths[i];
            array[i][3] = i;
        } 
        Arrays.sort(array, (a,b) -> (a[0]-b[0]));
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < positions.length; i++){
            if(array[i][2] == 1){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && array[stack.peek()][1] < array[i][1]){
                    int pos = stack.pop();
                    array[i][1] -= 1;
                    array[pos][1] = 0;
                }
                if(!stack.isEmpty()){
                    if(array[stack.peek()][1] > array[i][1])
                        array[stack.peek()][1] -= 1;
                    else{
                        array[stack.pop()][1] = 0;
                    }
                    array[i][1] = 0;
                }
            }
        }
        Arrays.sort(array,(a,b)->(a[3]-b[3]));
        List<Integer> list =new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            if(array[i][1] > 0){
                list.add(array[i][1]);
            }
        }
        return list;
    }
}