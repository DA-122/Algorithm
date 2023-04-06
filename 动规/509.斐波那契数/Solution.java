// Á¦¿Û509 ì³²¨ÄÇÆõÊý
public class Solution
{
    // µÝ¹é
    public static int fib(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }
    // µü´ú
    public static int fibIter(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            int [] f = new int[n+1];
            f[0] = 0;
            f[1] = 1 ;
            for(int i = 2; i <= n; i++){
                f[i] = f[i-1]+f[i-2];
            }
            return f[n];
        }
    }
    public static void main(String[] args){
        System.out.println("Recursion:"+fib(10));
        System.out.println("Iteration:"+fibIter(10));
    }
}
