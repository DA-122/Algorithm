// 2347.有效时间的数目
// 思路分析：有效时间的数目
// 多条件模拟

public class Solution {
    public int countTime(String time) {
        int result = 1;
        if(time.charAt(0) == '?'&& time.charAt(1) =='?'){
            result*=24;
        }else{
            if(time.charAt(0) == '?'){
                if(time.charAt(1)  < '4')
                    result*=3;
                else 
                    result*=2;
            }
            if(time.charAt(1) == '?'){
                if(time.charAt(0)  <= '1')
                    result*=10;
                else 
                    result*=4;
            }
        } 
        if(time.charAt(3) == '?'&& time.charAt(4) =='?'){
            result*=60;
        }else{
            if(time.charAt(3) == '?'){
                result*=6;
            }
            if(time.charAt(4) == '?'){
                result*=10;
            }
        } 
        return result;
    }
}