/* 
 * 花花有一个很珍贵的数字串，但是它太长了，没有办法保留下来，所以她想截取其中一段保存下来，
 * 但是她希望截取下来的这一段数对1000000007取模之后等于Ai，她想知道有多少种截取方案。
 * 数字串S中截取一段是指S[L], S[L+1], …, S[R]连起来所形成的十进制数，
 * 其中L和R满足1≤L≤R≤|S|。例如S=“1023456789”，S(1,2)=10，S(2,4)=23，S(2,10)=23456789。
*/
// 输入
// 第一行一个数字串，长度不超过30000。
// 第二行一个数T，表示询问的数量。（T≤100）
// 接下来T行，每行一个非负整数Ai，表示询问有多少种截取方案使得其值模1000000007后等于Ai。（0≤Ai<1000000007）

// 输出
// 共T行，每行一个非负整数，表示方案数。

// 思路分析：递归，分为左右两区，直到左右两区长度都是1
// 复杂度为n^2
import java.util.HashMap;
import java.util.Scanner;

import java.util.Map;;

public class Solution{
    static Map<Integer,Integer> map = new HashMap();

    public static void main(String[] args){
        int MOD = 1000000007;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int queryNum = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < queryNum; i++){ 
            int num = Integer.parseInt(sc.nextLine());
            map.put(num,0);
        }
        for(int i = 0; i < str.length(); i++){

        }
    }
    public static int division(String left, String right){
        if(left.length() == 1 && right.length() == 1){
            int r = Integer.parseInt(right);
            int l = Integer.parseInt(left);
            map.put(r, map.getOrDefault(r,0)+1);
            map.put(l, map.getOrDefault(l,0)+1);
            return l*10 + r;
        }
        int l = 0;
        int r = 0;
        if(left.length() == 1){
            l = Integer.parseInt(left);
            map.put(l, map.getOrDefault(l,0)+1);
        }else{
            int mid = left.length() / 2;
            l = division(left.substring(0, mid), left.substring(mid));
        }

        if(right.length() == 1){
            r = Integer.parseInt(right);
            map.put(r, map.getOrDefault(r,0)+1);
        }else{
            int mid = right.length() / 2;
            l = division(right.substring(0, mid), right.substring(mid));
        }
        return l + r;
    }
}