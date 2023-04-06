// 3.19周赛 6322.检查骑士巡视方案
// 思路分析：从[0,0]出发模拟骑士,看是否能到达gird[i][j] = n-1
// 1 递归模拟
// 2 给grid按大小排序，从小到大检验curRow lastRow curCol leftCol差是否复合规则
class Solution {
    // 递归模拟
    static int[][] step = {{-2,-1},{-1,-2},{-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}};
    public static boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0){
            return false;
        }
        return checkValid(0,0,0,grid.length,grid);
    }
    public static boolean checkValid(int num, int curRow, int curCol, int n,int[][] grid){
        if(num == n*n-1)
            return true;
        int nextRow = 0;
        int nextCol = 0;
        for(int i = 0; i < step.length; i++){
            nextRow = curRow+step[i][0];
            nextCol = curCol+step[i][1];
            if((0 <= nextRow)&& (nextRow < n)&&(0 <= nextCol)&&(nextCol < n)){
                if(grid[nextRow][nextCol] == num+1)
                    return checkValid(num+1,nextRow,nextCol,n,grid);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] grid ={{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},
    {24,13,2,7,22}};
        System.out.println(checkValidGrid(grid));

    }
}