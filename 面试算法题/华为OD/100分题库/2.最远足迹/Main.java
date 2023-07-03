// 题目： 最远足迹
// https://blog.csdn.net/2301_76848549/article/details/130797008
// 思路分析：
// 1.解析字符串
// 2.判断坐标是否合法
// 3.求最远
import java.util.Scanner;


public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String record = in.nextLine();
        int last = -1;
        int max = 0;
        String result = "(0,0)";
        for(int i = 0; i < record.length(); i++){
            if(record.charAt(i) == '('){
                last = i;
            }else if(record.charAt(i) == ')'&& last != -1){
                String pos = record.substring(last, i+1);
                int dis = isValid(pos);
                if(dis > max){
                    max = dis;
                    result = pos;
                }
                last = -1;
            } 
        }
        System.out.print(result);
    }

    // -1 不合格
    // > 0 合格 ，返回距离
    public static int isValid(String pos){
        int res = 0;
        int n = pos.length();
        if(n < 5){
            return -1;
        }
        String [] postions = pos.substring(1, n-1).split(",");
        if(postions.length != 2){
            return -1;
        }else{
            for(String str: postions){
                if(str.charAt(0) == '0')
                    return -1;
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) > '9' || str.charAt(i) < '0'){
                        return -1;
                    }
                }
                int num = Integer.parseInt(str);
                if(num <= 0 || num>1000){
                    return -1;
                }
                res += Math.pow(Integer.parseInt(str),2);
            }
        }
        return res;
    }
}