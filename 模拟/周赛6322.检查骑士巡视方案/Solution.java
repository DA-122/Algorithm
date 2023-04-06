// 3.19���� 6322.�����ʿѲ�ӷ���
// ˼·��������[0,0]����ģ����ʿ,���Ƿ��ܵ���gird[i][j] = n-1
// 1 �ݹ�ģ��
// 2 ��grid����С���򣬴�С�������curRow lastRow curCol leftCol���Ƿ񸴺Ϲ���
class Solution {
    // �ݹ�ģ��
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