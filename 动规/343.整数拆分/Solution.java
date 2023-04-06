// 力扣343 整数拆分
// 
public class Solution {
    public static int integerBreak(int n) {
        int [] array = new int[n+1];
        array[1] = 1;
        array[2] = 1;
        for(int i = 3 ; i < n+1; i++){
            array[i] = 0;
            for(int j = 1; j <= i/2; j++){
                array[i] = Math.max(Math.max(array[i-j],i-j)*Math.max(array[j],j),array[i]);
            }
        }
        return array[n];
    }
    public static void main(String[] args){
        System.out.println("Recursion:"+integerBreak(10));
        System.out.println("Iteration:"+integerBreak(10));
    }
}
