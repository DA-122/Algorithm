// 剑指44.数字序列中某一位的数字
public class Solution{
    public static int findNthDigit(int n) {
        int i = 1;
        if(n < 10){
            return n;
        }
        // current指向i位数最后一个数字最后一位的位置
        double current = 9;
        while(n > current){
            current += (i+1)*9*Math.pow(10,i);
            i++;
        }
        
        int bitNum = i - 1;
        while(bitNum>1){
            n -= (bitNum)*9*(int)Math.pow(10,bitNum-1);
            bitNum--;
        }
        n -= 9;
        int m = n/i;
        // 高位往低位数第几位
        int bit = n%i;
        int result = 1;
        for(int j = 0; j < i-1; j++){   
            result = result*10;
        } 
        int ans = 0;  
        result += m;
        if(bit == 0){
            ans = (result-1)%10;
        }else{
            while((i-bit)>0){
                result = result/10;
                bit++; 
            }
            ans = result%10;
        }
        return ans;
    }
    public static void main(String[] args){
        int n =1000;
        System.out.println(findNthDigit(n));
    }
}