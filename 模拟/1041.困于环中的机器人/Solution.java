// 1041 困于环中的机器人
// 题目分析： 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。注意:
// 北方向 是y轴的正方向。
// 南方向 是y轴的负方向。
// 东方向 是x轴的正方向。
// 西方向 是x轴的负方向。
// 机器人可以接受下列三条指令之一：
// "G"：直走 1 个单位
// "L"：左转 90 度
// "R"：右转 90 度
// 机器人按顺序执行指令 instructions，并一直重复它们。
// 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
// 思路分析： 一轮指令执行完成后，如果机器人在原点：
// 1. 面朝北，恢复到出发时的状态，必然有环
// 2. 面朝南，再执行一轮就回到原点且面朝北
// 3。 面朝东/面朝西， 再执行三轮就回到原点且面朝北。

// 如果机器人不位于原点：
// 1. 位于(x,y)且面朝北， 执行一轮后位于(2x,2y)面朝北，脱离环
// 2. 位于(x,y)且面朝南,  执行一轮后位于原点，面北
// 3. 位于(x,y)面朝东或面朝西，执行一轮变成(x+y,y-x)面北 或面南，执行四轮必然回到原点

public class Solution{
    public static boolean isRobotBounded(String instructions) {
        // dir 0 - 3  西 北 东 南
        int x = 0, y = 0;
        int dir = 1;
        int [][]directions = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 0; i < instructions.length(); i++){
            if(instructions.charAt(i) == 'L'){
                dir = (dir+3)%4;
            }
            if(instructions.charAt(i) =='R'){
                dir = (dir+1)%4;
            }
            if(instructions.charAt(i) =='G'){
                x += directions[dir][0];
                y += directions[dir][1];
            }
        }
        return (x == 0 && y==0) || dir!=1;
    }
    public static void main(String[] args){
        String instructions = "GGLLGG";
        System.out.println(isRobotBounded(instructions));
    }
}