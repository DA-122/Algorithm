// 题目: 报文重排序
// https://www.ppmy.cn/news/104042.html?action=onClick
// 思路分析：
// 1.按空格分割字符串
// 2.对每个子串分割数字后缀和报文内容，并以后缀为key存放到哈希表
// 3.按顺序从哈希表取子串拼接

import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        String line = in.nextLine();
        HashMap<Integer,String> map = new HashMap<>();
        String [] grams = line.split(" ");
        for(String gram: grams){
            int n = gram.length();
            for(int i = 0; i < n; i++){
                if(gram.charAt(i) >= '0' && gram.charAt(i) <='9'){
                    map.put(Integer.parseInt(gram.substring(i, n)),gram.substring(0, i));
                    break;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= grams.length; i++){
            sb.append(map.get(i)+" ");
        }
        System.out.println(sb.toString());
    }
}
