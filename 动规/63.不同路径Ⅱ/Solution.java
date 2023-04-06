// ����63 ��ͬ·����
// ˼·����: �������ϰ���Ԫ���ϰ���Ԫ��·����Ϊ0����ʼֵ����ҲӦ���������������ϰ��޷��ݹ���
// ���ƹ�ʽ: grid[m][n] = gird[m-1][n]+grid[m][n-1]
// ��ʼֵ: m = 0 �� n = 0 ����û���ϰ����ϰ���ߵĸ���ҲȫΪ0������һ�е�һ������������ϰ��ĸ��Ӷ���0
// ����: ��ǰ����

public class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] grid = new int [m][n];
        boolean isBlock = false;
        for (int i = 0 ; i< m; i++){
            if(obstacleGrid[i][0]==1)
                isBlock = true;
            if(!isBlock)
                grid[i][0] = 1;
            else
                grid[i][0] = 0;
        }
        isBlock = false;
        for (int i = 0 ; i< n; i++){
            if(obstacleGrid[0][i]==1)
                isBlock = true;
            if(!isBlock)
                grid[0][i] = 1;
            else
                grid[0][i] = 0;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n ; j++){
                if(obstacleGrid[i][j] != 1){
                    grid[i][j] = grid[i-1][j]+ grid[i][j-1];
                }else{  
                    grid[i][j] = 0;
                }
            }
        }
        return grid[m-1][n-1];
    }
    public static void main(String[] args){
        int[][] arg = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println("Recursion:"+uniquePathsWithObstacles(arg));
    }
}
