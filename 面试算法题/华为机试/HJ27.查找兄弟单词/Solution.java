// 注意使用java的api节省时间，避免重复造轮子

// 兄弟单词：1. 哈希表，对比每个key的value
// 2. 转化为数组，sort之后，如果两个数组完全一样就是兄弟单词

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String line = in.nextLine();
        String[] words = line.split(" ");
        int length = words.length;
        String x = words[length - 2];
        int n = Integer.parseInt(words[0]);
        int k = Integer.parseInt(words[length - 1]);
        int m = 0;
        List<String> strs = new ArrayList<>();
        for(int i = 1; i < length-2; i++){
            if(isSibling(words[i],x)){
                strs.add(words[i]);
                m++;
            }
        }
        Collections.sort(strs);
        System.out.println(m);
        if(k <= m)
            System.out.print(strs.get(k-1));
    }
    public static boolean isSibling(String str, String pattern){
        if(str.length() != pattern.length() || str.equals(pattern)){
            return false;
        }

        char[] c1 = str.toCharArray();
        char[] c2 = pattern.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }
}