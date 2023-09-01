// 新技巧：哈希表存储二元数
// 坐标范围在-3 * 10 ^ 4  - 3 * 10 ^4之间
// 使用哈希函数进行映射
import java.util.HashSet;
import java.util.Set;

public class Solution{
    public static void main(String[] args){
        S s = new S();
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        s.robotSim(commands, obstacles);
    }
}

class S {
    // 上 左 下 右
    int move[][] = {{0,1},{-1,0},{0,-1},{1,0}};
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int max = 0;
        int direction = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < obstacles.length; i++){
            set.add(obstacles[i][0] * 60001 + obstacles[i][1]);
        }

        for(int i = 0; i < commands.length; i++){
            // 向右转
            if(commands[i] == -1){
                direction = (direction + 4 - 1) % 4;
            }else if(commands[i] == -2){
                direction = (direction + 1) % 4;
            }else{
                for(int j = 0; j < commands[i]; j++){
                    int curX = x + move[direction][0];
                    int curY = y + move[direction][1];
                    if(set.contains(curX * 60001 + curY)){
                        break;
                    }else{
                        x = curX;
                        y = curY;
                        max = Math.max(max,x*x+y*y);
                    }
                }
            }
        } 
        return max;
   }
}