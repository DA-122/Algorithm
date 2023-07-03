// 题目： IPV4地址转化为整数
// https://blog.csdn.net/zhizhengguan/article/details/126752615#:~:text=1%20%E7%AC%AC%E4%B8%80%E6%AD%A5%EF%BC%9A%E5%85%88%E5%AF%B9%E5%AD%97%E7%AC%A6%E4%B8%B2%E8%BF%9B%E8%A1%8C%E5%88%87%E5%89%B2%202%20%E7%AC%AC%E4%BA%8C%E6%AD%A5%EF%BC%9A%E5%88%A4%E6%96%ADIP%E5%9C%B0%E5%9D%80%E6%98%AF%E5%90%A6%E5%90%88%E6%B3%95%203%20%E7%AC%AC%E4%B8%89%E6%AD%A5%EF%BC%9A%E5%B0%86IP%E5%9C%B0%E5%9D%80%E8%BD%AC%E6%8D%A2%E4%B8%BA%E6%95%B4%E6%95%B0%20%E9%A6%96%E5%85%88%E4%BD%BF%E7%94%A8%E6%8A%8AIP%E5%9C%B0%E5%9D%80%E5%88%86%E6%88%904%E4%B8%AA%E6%95%B0%E5%AD%97%EF%BC%9A%20128,10000000%2011000111%2011100111%2000101100%20%E6%8A%8A%E8%BF%994%E4%B8%AA%E4%BA%8C%E8%BF%9B%E5%88%B6%E6%95%B0%E7%9B%B4%E6%8E%A5%E8%AF%84%E4%BB%B7%E5%9C%A8%E4%B8%80%E8%B5%B7%EF%BC%9A%2010000000110001111110011100101100%20%E6%8B%BC%E6%8E%A5%E4%BB%A5%E5%90%8E%E7%9A%84%E4%BA%8C%E8%BF%9B%E5%88%B6%E6%95%B0%E8%BD%AC%E6%8D%A2%E4%B8%BA10%E8%BF%9B%E5%88%B6%E6%95%B0%EF%BC%9A%202160584492
// 思路分析： 
// 1. 分割字符串
// 2.检验ip地址合法性
// 3.将4个地址转化为8位二进制，连接后转化为10进制， 或者直接二进制移位相加（推荐）

// 相关练习： 10进制数字转2进制字符串
// 2进制字符串转10进制整数

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        String[] ips = ip.split("#");
        // StringBuilder sb = new StringBuilder();
        int result = 0;

        if(ips.length != 4){
            System.out.print("invalid IP");
            return;
        }else{
            for(int i = 0; i < 4; i++){
                int num = Integer.parseInt(ips[i]);
                if(num <0 || num >255){
                    System.out.print("invalid IP");
                    return;
                }else{
                    // String binaryStr = Integer.toBinaryString(num);
                    // for(int j = 0; j < 8 - binaryStr.length(); j++){
                    //     sb.append("0");
                    // }
                    // sb.append(binaryStr);
                    // 实际上直接左移就行
                    result += num << (8 * (3 - i)); 
                }
            }
        }

        // System.out.println(Integer.parseUnsignedInt(sb.toString(),2));
        System.out.println(result);
        
    }
    // 10进制转2进制字符串 练习
    public static String iToBs(int num){
        StringBuffer sb = new StringBuffer();
        while(num > 0){
            sb.append(num % 2);
            num = num/2;
        }
        int size = sb.length();
        for(int i = 0; i < 8 - size; i++){
            sb.append(0);
        }
        return sb.reverse().toString();
    }
    // 32位二进制转字符串
    public static int bsToI(String str){
        int result = 0;
        for(int i = 31 ; i >=0; i--){
            result += Math.pow(2,31-i) * (str.charAt(i) - '0');
        }
        return result;
    }

}